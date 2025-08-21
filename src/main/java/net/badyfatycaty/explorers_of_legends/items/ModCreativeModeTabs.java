package net.badyfatycaty.explorers_of_legends.items;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.block.ModBlocks;
import net.badyfatycaty.explorers_of_legends.items.categories.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExplorersOfLegends.MOD_ID);

    public static final Supplier<CreativeModeTab> EOE_BUILDING_BLOCKS_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_building_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CERAMIC))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_building_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CASTING_SAND);
                        output.accept(ModBlocks.CASTING_CLAY);
                        output.accept(ModBlocks.CERAMIC);
                        output.accept(ModBlocks.CRYSTALLIZED_MAGMA_BLOCK);
                        output.accept(ModBlocks.FORGED_IRON_BLOCK);
                        output.accept(ModBlocks.CHISELED_FORGED_IRON);
                        output.accept(ModBlocks.CUT_FORGED_IRON);
                    }).build());

    public static final Supplier<CreativeModeTab> EOE_FUNCTIONAL_BLOCKS_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_functional_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FORGE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExplorersOfLegends.MOD_ID, "explorers_of_legends_building_blocks"))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_functional_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.FORGE);
                        output.accept(ModBlocks.CASTING_TABLE);
                        output.accept(ModBlocks.CASTING_BASIN);
                        output.accept(ModBlocks.SMITHY);
                    }).build());

    public static final Supplier<CreativeModeTab> EOE_TOOLS_AND_UTILITIES_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_tools_and_utilities",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ItemLike) ForgedIronItems.FORGED_IRON_PICKAXE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExplorersOfLegends.MOD_ID, "explorers_of_legends_functional_blocks"))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_tools_and_utilities"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ForgedIronItems.FORGED_IRON_SHOVEL);
                        output.accept(ForgedIronItems.FORGED_IRON_PICKAXE);
                        output.accept(ForgedIronItems.FORGED_IRON_AXE);
                        output.accept(ForgedIronItems.FORGED_IRON_HOE);
                    }).build());

    public static final Supplier<CreativeModeTab> EOE_COMBAT_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_combat",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ItemLike) ForgedIronItems.FORGED_IRON_SWORD))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExplorersOfLegends.MOD_ID, "explorers_of_legends_tools_and_utilities"))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_combat"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ForgedIronItems.FORGED_IRON_AXE);
                        //output.accept(ForgedIronItems.FORGED_IRON_CROSSBOW);
                        output.accept(ForgedIronItems.FORGED_IRON_BOW);
                        output.accept(ForgedIronItems.FORGED_IRON_CHAKRAM);
                        output.accept(ForgedIronItems.FORGED_IRON_CLAYMORE);
                        output.accept(ForgedIronItems.FORGED_IRON_DAGGER);
                        output.accept(ForgedIronItems.FORGED_IRON_DOUBLE_AXE);
                        output.accept(ForgedIronItems.FORGED_IRON_GLAIVE);
                        output.accept(ForgedIronItems.FORGED_IRON_GREATSWORD);

                        output.accept(ForgedIronItems.FORGED_IRON_KATANA);
                        output.accept(ForgedIronItems.FORGED_IRON_MACE);
                        output.accept(ForgedIronItems.FORGED_IRON_SCYTHE);
                        output.accept(ForgedIronItems.FORGED_IRON_SICKLE);
                        output.accept(ForgedIronItems.FORGED_IRON_SWORD);
                        output.accept(ForgedIronItems.FORGED_IRON_SHIELD);
                        output.accept(ForgedIronItems.FORGED_IRON_SPEAR);
                        output.accept(ForgedIronItems.FORGED_IRON_WARGLAIVE);

                        output.accept(ForgedIronItems.FORGED_IRON_LONGBOW);

                    }).build());

    public static final Supplier<CreativeModeTab> EOE_INGREDIENTS_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ItemLike) ForgedIronItems.FORGED_IRON_INGOT))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExplorersOfLegends.MOD_ID, "explorers_of_legends_combat"))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_ingredients"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CRYSTALLIZED_MAGMA);
                        output.accept(CrucibleItems.CURCIBLE);
                        output.accept(CrucibleItems.RAW_IRON_AND_DIAMOND_CRUCIBLE);
                        output.accept(CrucibleItems.FORGED_IRON_SCRAP_FILLED_CRUCIBLE);
                        output.accept(CrucibleItems.FORGED_IRON_CURCIBLE);
                        output.accept(ForgedIronItems.FORGED_IRON_NUGGET);
                        output.accept(ForgedIronItems.FORGED_IRON_NUGGET_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_INGOT);
                        output.accept(ForgedIronItems.FORGED_IRON_INGOT_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_SHEET);
                        output.accept(ForgedIronItems.FORGED_IRON_SHEET_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_STICK);
                        output.accept(ForgedIronItems.FORGED_IRON_STICK_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_STRING);
                        output.accept(ForgedIronItems.FORGED_IRON_STRING_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_SCRAP);
                        output.accept(ForgedIronItems.FORGED_IRON_SCRAP_HOT);
                        output.accept(ForgedIronItems.TINY_BLOCK_OF_FORGED_IRON);
                        output.accept(ForgedIronItems.TINY_BLOCK_OF_FORGED_IRON_HOT);
                        output.accept(ForgedIronItems.SMALL_BLOCK_OF_FORGED_IRON);
                        output.accept(ForgedIronItems.SMALL_BLOCK_OF_FORGED_IRON_HOT);
                        output.accept(ForgedIronItems.MEDIUM_BLOCK_OF_FORGED_IRON);
                        output.accept(ForgedIronItems.MEDIUM_BLOCK_OF_FORGED_IRON_HOT);
                        output.accept(ForgedIronItems.LARGE_BLOCK_OF_FORGED_IRON);
                        output.accept(ForgedIronItems.LARGE_BLOCK_OF_FORGED_IRON_HOT);
                        output.accept(ForgedIronItems.HUGE_BLOCK_OF_FORGED_IRON);
                        output.accept(ForgedIronItems.HUGE_BLOCK_OF_FORGED_IRON_HOT);

                        output.accept(ForgedIronItems.FORGED_IRON_AXE_HEAD);
                        output.accept(ForgedIronItems.FORGED_IRON_AXE_HEAD_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_BOW_STAVE);
                        output.accept(ForgedIronItems.FORGED_IRON_BOW_STAVE_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_CHAKRAM_BLADE);
                        output.accept(ForgedIronItems.FORGED_IRON_CHAKRAM_BLADE_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_CLAYMORE_BLADE);
                        output.accept(ForgedIronItems.FORGED_IRON_CLAYMORE_BLADE_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_CLAYMORE_GUARD);
                        output.accept(ForgedIronItems.FORGED_IRON_CLAYMORE_GUARD_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_DAGGER_BLADE);
                        output.accept(ForgedIronItems.FORGED_IRON_DAGGER_BLADE_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_DOUBLE_AXE_HEAD);
                        output.accept(ForgedIronItems.FORGED_IRON_DOUBLE_AXE_HEAD_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_GLAIVE_BLADE);
                        output.accept(ForgedIronItems.FORGED_IRON_GLAIVE_BLADE_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_GLAIVE_POMMEL);
                        output.accept(ForgedIronItems.FORGED_IRON_GLAIVE_POMMEL_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_GREATSWORD_BLADE);
                        output.accept(ForgedIronItems.FORGED_IRON_GREATSWORD_BLADE_HOT);
                        output.accept(ForgedIronItems.FORGED_IRON_GREATSWORD_GUARD);
                        output.accept(ForgedIronItems.FORGED_IRON_GREATSWORD_GUARD_HOT);

                        output.accept(ModItems.RED_WRAPPED_STICK);
                        output.accept(ModItems.RED_WRAPPED_STICK_LONG);
                        output.accept(ForgedIronItems.FORGED_IRON_HANDLE);
                        output.accept(ForgedIronItems.FORGED_IRON_BOWSTRING);

                        output.accept(SandCastItems.BLANK_SAND_CAST);
                        output.accept(SandCastItems.SAND_NUGGET_CAST);
                        output.accept(SandCastItems.SAND_INGOT_CAST);
                        output.accept(SandCastItems.SAND_STICK_CAST);
                        output.accept(SandCastItems.SAND_STRING_CAST);
                        output.accept(SandCastItems.SAND_AXE_HEAD_CAST);
                        output.accept(SandCastItems.SAND_BOW_STAVE_CAST);
                        output.accept(SandCastItems.SAND_CHAKRAM_BLADE_CAST);
                        output.accept(SandCastItems.SAND_CLAYMORE_BLADE_CAST);
                        output.accept(SandCastItems.SAND_CLAYMORE_GUARD_CAST);
                        output.accept(SandCastItems.SAND_DAGGER_BLADE_CAST);
                        output.accept(SandCastItems.SAND_DOUBLE_AXE_HEAD_CAST);
                        output.accept(SandCastItems.SAND_GLAIVE_BLADE_CAST);
                        output.accept(SandCastItems.SAND_GLAIVE_POMMEL_CAST);
                        output.accept(SandCastItems.SAND_GREATSWORD_BLADE_CAST);
                        output.accept(SandCastItems.SAND_GREATSWORD_GUARD_CAST);

                        output.accept(ClayCastItems.BLANK_CLAY_CAST);
                        output.accept(CeramicCastItems.BLANK_CERAMIC_CAST);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}