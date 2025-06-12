package net.badyfatycaty.explorers_of_legends.client;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.attributes.crit.CritDamage;
import net.badyfatycaty.explorers_of_legends.attributes.crit.CritRate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.Random;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;

@EventBusSubscriber(modid = ExplorersOfLegends.MODID, bus = EventBusSubscriber.Bus.GAME, value = {Dist.CLIENT})
public class CritHandler {

    private static final ResourceLocation CRIT_RATE = ResourceLocation.withDefaultNamespace("generic.crit_rate");
    private static final ResourceLocation CRIT_DAMAGE = ResourceLocation.withDefaultNamespace("generic.crit_damage");

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

        if (Math.random() < critRate) {
            float base = event.getOriginalDamage();
            float bonus = base * (float)(critDamage - 1);
            event.setNewDamage(base + bonus);

            livingAttacker.level().playSound(null, livingAttacker.getX(), livingAttacker.getY(), livingAttacker.getZ(),
                    SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.PLAYERS, 1.0f, 1.0f);

            // Spawn custom crit particle
            LivingEntity target = event.getEntity();
            if (!target.getCommandSenderWorld().isClientSide()) {
                target.addTag("crit_hitted");
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
