package net.badyfatycaty.explorers_of_legends.components;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.rarity.ModRarity;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, ExplorersOfLegends.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<EnchantmentLimitComponent>> ENCHANT_LIMIT =
        register("enchant_limit", builder -> builder
            .persistent(EnchantmentLimitComponent.CODEC)
            .networkSynchronized(EnchantmentLimitComponent.STREAM_CODEC)
        );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ModRarity>> RARITY =
        register("rarity", builder -> builder
            .persistent(ModRarityComponent.CODEC)
            .networkSynchronized(ModRarityComponent.STREAM_CODEC)
        );

    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                         UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return COMPONENTS.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus bus) {
        COMPONENTS.register(bus);
    }
}