package net.badyfatycaty.explorers_of_legends.items.custom.weapon_types;

import net.badyfatycaty.explorers_of_legends.attributes.crit.CritDamage;
import net.badyfatycaty.explorers_of_legends.attributes.crit.CritRate;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.TooltipPhysicalDMG;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.slicing.SlicingDamage;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.slicing.SlicingResistance;
import net.badyfatycaty.explorers_of_legends.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;

import static net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.slicing.SlicingDamage.SLICING_DAMAGE;

public class EoLGlaiveItem extends TieredItem {
    public EoLGlaiveItem(Tier tier, Properties properties) {
        super(tier, properties
                .attributes(createAttributes(tier, 2.5F, 0.5F, 0.01F, 0.1F, -2.6F))
                .component(DataComponents.TOOL, createToolProperties())
        );
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, int slicingDamage, int critRate, int critDMG, float attackSpeed) {
        return createAttributes(tier, (float)attackDamage, (float)slicingDamage, (float)critRate, (float)critDMG, attackSpeed);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float slicingDamage, float critRate, float critDMG, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)attackDamage + slicingDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(SLICING_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(slicingDamage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(TooltipPhysicalDMG.TOOLTIP_ATTACK, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)attackDamage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(CritRate.CRIT_RATE, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)critRate, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(CritDamage.CRIT_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)critDMG, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    public EoLGlaiveItem(Tier p_tier, Properties p_properties, Tool toolComponentData) {
        super(p_tier, p_properties.component(DataComponents.TOOL, toolComponentData));
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_SWORD_ACTIONS.contains(itemAbility);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 2.5% chance to apply or increase Bleeding effect
        if (!target.level().isClientSide && attacker.getRandom().nextFloat() < 0.025f) {
            int duration = 100; // 5 seconds (100 ticks)
            int newAmplifier = 0;
            if (target.hasEffect(ModEffects.BLEEDING_EFFECT)) {
                newAmplifier = target.getEffect(ModEffects.BLEEDING_EFFECT).getAmplifier() + 1;
            }
            target.addEffect(new MobEffectInstance(ModEffects.BLEEDING_EFFECT, duration, newAmplifier));
        }
        return true;
    }
}
