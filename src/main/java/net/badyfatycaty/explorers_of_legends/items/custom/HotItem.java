package net.badyfatycaty.explorers_of_legends.items.custom;

import net.badyfatycaty.explorers_of_legends.block.entity.ForgeBlockEntity;
import net.badyfatycaty.explorers_of_legends.block.entity.ModBlockEntities;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class HotItem extends Item {
    private final Supplier<ItemStack> cooledItem;
    private boolean barVisability = true;

    public HotItem(Properties properties, int cooldownTimeSec, Supplier<ItemStack> cooledItem, boolean barVisability) {
        super(properties.durability(20*cooldownTimeSec));
        this.cooledItem = cooledItem;
        this.barVisability = barVisability;
    }

    public HotItem(Properties properties, int cooldownTimeSec, Supplier<ItemStack> cooledItem) {
        super(properties.durability(20*cooldownTimeSec));
        this.cooledItem = cooledItem;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int currentHeat = stack.getMaxDamage() - stack.getDamageValue();
        int maxHeat = stack.getMaxDamage();

        tooltipComponents.add(Component.literal(""));
        MutableComponent textComponent = Component.translatable("item.explorers_of_legends.heatable.tooltip").withStyle(ChatFormatting.GRAY);
        MutableComponent textComponent2 = Component.translatable("item.explorers_of_legends.item_heat.tooltip").withStyle(ChatFormatting.WHITE);
        MutableComponent durabilityComponent = Component.literal(": ").withStyle(ChatFormatting.WHITE)
                .append(Component.literal(currentHeat + "/" + maxHeat).withStyle(ChatFormatting.RED));
        tooltipComponents.add(textComponent);
        tooltipComponents.add(textComponent2.append(durabilityComponent));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return barVisability;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float durabilityPercent = (stack.getMaxDamage() - stack.getDamageValue()) / (float) stack.getMaxDamage();

        // Red (hot) = (255, 51, 0)
        // Blue (cool) = (0, 128, 255)
        int red   = (int) (255 * durabilityPercent + 0 * (1 - durabilityPercent));
        int green = (int) (0 * durabilityPercent + 255 * (1 - durabilityPercent));
        int blue  = (int) (0   * durabilityPercent + 255 * (1 - durabilityPercent));

        return (red << 16) | (green << 8) | blue;
    }

    public ItemStack getCooledItem() { return cooledItem.get(); }

    //TODO: Make these items unable to go into any inventories other than the player and the forge.
    // For the blocks, make it so i can easily add more if i want to. Also make it so hoppers cant pick this up.

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (stack.getDamageValue() < stack.getMaxDamage()) {
                int newDamage = stack.getDamageValue() + 1;
                stack.setDamageValue(newDamage);

                // sound at halfway and full cooldown
                if (newDamage == stack.getMaxDamage() / 2 || newDamage == stack.getMaxDamage()) {
                    level.playSound(
                            null,
                            entity.blockPosition(),
                            SoundEvents.FIRE_EXTINGUISH,
                            SoundSource.PLAYERS,
                            1.0f,
                            1.0f
                    );
                }

                // when fully cooled, turn into normal ingot
                if (newDamage >= stack.getMaxDamage() && entity instanceof Player player2) {
                    player2.getInventory().setItem(slot,
                            new ItemStack(getCooledItem().getItem()));
                }
            }
        }
    }
}