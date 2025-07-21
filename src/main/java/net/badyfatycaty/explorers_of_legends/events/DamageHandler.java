package net.badyfatycaty.explorers_of_legends.events;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.attributes.crit.CritDamage;
import net.badyfatycaty.explorers_of_legends.attributes.crit.CritRate;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.blunt.BluntDamage;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.blunt.BluntResistance;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.piercing.PiercingDamage;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.piercing.PiercingResistance;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.slicing.SlicingDamage;
import net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.slicing.SlicingResistance;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.Random;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;

@EventBusSubscriber(modid = ExplorersOfLegends.MODID, bus = EventBusSubscriber.Bus.GAME, value = {Dist.CLIENT})
public class DamageHandler {
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onCritCheck(LivingDamageEvent.Pre event) {
        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();
        if (!(attacker instanceof LivingEntity livingAttacker)) return;

        var critRateHolder = BuiltInRegistries.ATTRIBUTE.getHolder(CritRate.CRIT_RATE.getId()).orElse(null);
        var critDamageHolder = BuiltInRegistries.ATTRIBUTE.getHolder(CritDamage.CRIT_DAMAGE.getId()).orElse(null);
        if (critRateHolder == null || critDamageHolder == null) return;
        System.out.println("Custom crit system triggered for " + livingAttacker.getName().getString());

        double critRate = livingAttacker.getAttribute(critRateHolder).getValue();
        double critDamage = livingAttacker.getAttribute(critDamageHolder).getValue();

//        // Get base attack damage
//        double baseAttackDamage = livingAttacker.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
//
//        // Check for slicing damage from item attributes
//        double slicingDamage = 0.0;
//        if (livingAttacker.getMainHandItem().has(DataComponents.ATTRIBUTE_MODIFIERS)) {
//            var modifiers = livingAttacker.getMainHandItem().get(DataComponents.ATTRIBUTE_MODIFIERS);
//            slicingDamage = modifiers.modifiers().stream()
//                .filter(mod -> mod.attribute().equals(SlicingDamage.SLICING_DAMAGE)
//                    && mod.slot().equals(EquipmentSlotGroup.MAINHAND))
//                .mapToDouble(modifier -> modifier.modifier().amount())
//                .sum();
//        }
//
//        // Check for piercing damage from item attributes
//        double piercingDamage = 0.0;
//        if (livingAttacker.getMainHandItem().has(DataComponents.ATTRIBUTE_MODIFIERS)) {
//            var modifiers = livingAttacker.getMainHandItem().get(DataComponents.ATTRIBUTE_MODIFIERS);
//            piercingDamage = modifiers.modifiers().stream()
//                    .filter(mod -> mod.attribute().equals(PiercingDamage.PIERCING_DAMAGE)
//                            && mod.slot().equals(EquipmentSlotGroup.MAINHAND))
//                    .mapToDouble(modifier -> modifier.modifier().amount())
//                    .sum();
//        }
//
//        // Check for blunt damage from item attributes
//        double bluntDamage = 0.0;
//        if (livingAttacker.getMainHandItem().has(DataComponents.ATTRIBUTE_MODIFIERS)) {
//            var modifiers = livingAttacker.getMainHandItem().get(DataComponents.ATTRIBUTE_MODIFIERS);
//            bluntDamage = modifiers.modifiers().stream()
//                    .filter(mod -> mod.attribute().equals(BluntDamage.BLUNT_DAMAGE)
//                            && mod.slot().equals(EquipmentSlotGroup.MAINHAND))
//                    .mapToDouble(modifier -> modifier.modifier().amount())
//                    .sum();
//        }
//
//        // Apply slicing resistance from target
//        double slicingResistance = 0.0;
//        Entity targetS = event.getEntity();
//        if (targetS instanceof LivingEntity livingTarget) {
//            var resistanceAttr = livingTarget.getAttribute(
//                SlicingResistance.SLICING_RESISTANCE
//            );
//            if (resistanceAttr != null) {
//                slicingResistance = resistanceAttr.getValue();
//            }
//        }
//
//        // Apply piercing resistance from target
//        double piercingResistance = 0.0;
//        Entity targetP = event.getEntity();
//        if (targetP instanceof LivingEntity livingTarget) {
//            var resistanceAttr = livingTarget.getAttribute(
//                    PiercingResistance.PIERCING_RESISTANCE
//            );
//            if (resistanceAttr != null) {
//                piercingResistance = resistanceAttr.getValue();
//            }
//        }
//
//        // Apply blunt resistance from target
//        double bluntResistance = 0.0;
//        Entity targetB = event.getEntity();
//        if (targetB instanceof LivingEntity livingTarget) {
//            var resistanceAttr = livingTarget.getAttribute(
//                    BluntResistance.BLUNT_RESISTANCE
//            );
//            if (resistanceAttr != null) {
//                bluntResistance = resistanceAttr.getValue();
//            }
//        }
//
//        // Apply resistance as a flat reduction (optional: cap at 0)
//        slicingDamage = Math.max(0, slicingDamage - slicingResistance);
//        piercingDamage = Math.max(0, piercingDamage - piercingResistance);
//        bluntDamage = Math.max(0, bluntDamage - bluntResistance);
//
//        // Override the base damage with calculated total
//        event.setNewDamage((float)(baseAttackDamage + slicingDamage + piercingDamage + bluntDamage));

        if (Math.random() < critRate) {
            float base = event.getNewDamage();
            float bonus = base * (float)(critDamage - 1);
            event.setNewDamage(base + bonus);

            livingAttacker.level().playSound(null, livingAttacker.getX(), livingAttacker.getY(), livingAttacker.getZ(),
                    SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.PLAYERS, 1.0f, 1.0f);

            // Spawn custom crit particle
            LivingEntity targetC = event.getEntity();
            if (!targetC.getCommandSenderWorld().isClientSide()) {
                targetC.addTag("crit_hitted");
            }
        }
    }

    @SubscribeEvent
    public static void onVanillaCrit(CriticalHitEvent event) {
        // Prevent vanilla crit behavior from taking effect
        event.setCriticalHit(false);
        event.setDamageMultiplier(1.0F); // Resets to normal base damage
    }
}
