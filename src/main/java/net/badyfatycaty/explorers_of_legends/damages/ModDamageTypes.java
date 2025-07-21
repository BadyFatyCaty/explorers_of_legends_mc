package net.badyfatycaty.explorers_of_legends.damages;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> SLICING =
            ResourceKey.create(Registries.DAMAGE_TYPE,
                    ResourceLocation.fromNamespaceAndPath("explorers_of_legends", "main_damage_types/physical/slicing"));

    public static DamageSource bleeding(ServerLevel level) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(BLEEDING_KEY));
    }

    public static DamageSource spectral(ServerLevel level) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(SPECTRAL_KEY));
    }

    public static DamageSource spectral(ServerLevel level, Entity attacker) {
        return new DamageSource(
                level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(SPECTRAL_KEY),
                attacker
        );
    }

    public static final ResourceKey<DamageType> BLEEDING_KEY =
            ResourceKey.create(Registries.DAMAGE_TYPE,
                    ResourceLocation.fromNamespaceAndPath("explorers_of_legends", "bleeding"));


    public static final ResourceKey<DamageType> SPECTRAL_KEY =
            ResourceKey.create(Registries.DAMAGE_TYPE,
                    ResourceLocation.fromNamespaceAndPath("explorers_of_legends", "main_damage_types/spirit/spectral"));
}