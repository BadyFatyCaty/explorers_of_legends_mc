package net.badyfatycaty.explorers_of_legends.items;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.block.ModBlocks;
import net.badyfatycaty.explorers_of_legends.items.categories.CrucibleItems;
import net.badyfatycaty.explorers_of_legends.items.categories.ForgedIronItems;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRYSTALLIZED_MAGMA_BLOCK))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_building_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CRYSTALLIZED_MAGMA_BLOCK);
                    }).build());

    public static final Supplier<CreativeModeTab> EOE_FUNCTIONAL_BLOCKS_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_functional_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FORGE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExplorersOfLegends.MOD_ID, "explorers_of_legends_building_blocks"))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_functional_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.FORGE);
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
                        output.accept(ForgedIronItems.FORGED_IRON_CLAYMORE);
                        output.accept(ForgedIronItems.FORGED_IRON_DAGGER);
                        output.accept(ForgedIronItems.FORGED_IRON_DOUBLE_AXE);
                        output.accept(ForgedIronItems.FORGED_IRON_GLAIVE);
                        output.accept(ForgedIronItems.FORGED_IRON_SCYTHE);
                        output.accept(ForgedIronItems.FORGED_IRON_SICKLE);
                        output.accept(ForgedIronItems.FORGED_IRON_SWORD);

                        output.accept(ForgedIronItems.FORGED_IRON_MACE);
                        output.accept(ForgedIronItems.FORGED_IRON_SHIELD);
                        output.accept(ForgedIronItems.FORGED_IRON_BOW);
                        //output.accept(ForgedIronItems.FORGED_IRON_CROSSBOW);
                        output.accept(ForgedIronItems.FORGED_IRON_SPEAR);

                        output.accept(ModItems.KATANA);
                        output.accept(ForgedIronItems.FORGED_IRON_KATANA);
                        output.accept(ModItems.ELEMENTAL_DISK);
                        output.accept(ForgedIronItems.FORGED_IRON_CHAKRAM);
                        output.accept(ForgedIronItems.FORGED_IRON_WARGLAIVE);

                    }).build());

    public static final Supplier<CreativeModeTab> EOE_INGREDIENTS_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ItemLike) ForgedIronItems.FORGED_IRON_INGOT))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExplorersOfLegends.MOD_ID, "explorers_of_legends_combat"))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_ingredients"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CRYSTALLIZED_MAGMA);
                        output.accept(CrucibleItems.CURCIBLE);
                        output.accept(CrucibleItems.RAW_IRON_AND_DIAMOND_CRUCIBLE);
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
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}