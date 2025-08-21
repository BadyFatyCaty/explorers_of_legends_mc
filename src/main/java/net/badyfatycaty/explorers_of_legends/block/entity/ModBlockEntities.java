package net.badyfatycaty.explorers_of_legends.block.entity;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ExplorersOfLegends.MOD_ID);

    public static final Supplier<BlockEntityType<ForgeBlockEntity>> FORGE_BE =
            BLOCK_ENTITIES.register("forge_be", () -> BlockEntityType.Builder.of(
                    ForgeBlockEntity::new, ModBlocks.FORGE.get()).build(null));

    public static final Supplier<BlockEntityType<CastingTableBlockEntity>> CASTING_TABLE_BE =
            BLOCK_ENTITIES.register("casting_table_be", () -> BlockEntityType.Builder.of(
                    CastingTableBlockEntity::new, ModBlocks.CASTING_TABLE.get()).build(null));

    public static final Supplier<BlockEntityType<CastingBasinBlockEntity>> CASTING_BASIN_BE =
            BLOCK_ENTITIES.register("casting_basin_be", () -> BlockEntityType.Builder.of(
                    CastingBasinBlockEntity::new, ModBlocks.CASTING_BASIN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}