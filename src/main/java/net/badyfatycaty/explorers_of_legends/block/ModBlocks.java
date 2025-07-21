package net.badyfatycaty.explorers_of_legends.block;

import com.mojang.serialization.MapCodec;
import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.block.custom.ForgeBlock;
import net.badyfatycaty.explorers_of_legends.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ExplorersOfLegends.MOD_ID);

    public static final DeferredBlock<Block> CASTING_TABLE = registerBlock("casting_table",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT)
                    .noOcclusion()
            ));

    public static final DeferredBlock<Block> CASTING_BASIN = registerBlock("casting_basin",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT)
                    .noOcclusion()
            ));

    public static final DeferredBlock<Block> FORGE = registerBlock("forge",
            () -> new ForgeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BASALT)
                    .lightLevel(state -> state.getValue(ForgeBlock.LIT) ? 5 : 0)
                    .noOcclusion()
            ));

    public static final DeferredBlock<Block> CRYSTALLIZED_MAGMA_BLOCK = registerBlock("crystallized_magma_block",
            () -> new MagmaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGMA_BLOCK)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> 7)
            ));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}