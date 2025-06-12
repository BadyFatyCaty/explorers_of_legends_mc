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

    public static final Supplier<CreativeModeTab> EOE_FUNCTIONAL_BLOCKS_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_functional_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FORGE))
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
                        output.accept(ForgedIronItems.FORGED_IRON_SWORD);
                        output.accept(ForgedIronItems.FORGED_IRON_CLAYMORE);
                        output.accept(ForgedIronItems.FORGED_IRON_AXE);
                        output.accept(ForgedIronItems.FORGED_IRON_MACE);
                        output.accept(ForgedIronItems.FORGED_IRON_SHIELD);
                        output.accept(ForgedIronItems.FORGED_IRON_DAGGER);
                        output.accept(ForgedIronItems.FORGED_IRON_BOW);
                        //output.accept(ForgedIronItems.FORGED_IRON_CROSSBOW);
                        output.accept(ForgedIronItems.FORGED_IRON_SPEAR);

                    }).build());

    public static final Supplier<CreativeModeTab> EOE_INGREDIENTS_TAB = CREATIVE_MODE_TAB.register("explorers_of_legends_ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack((ItemLike) ForgedIronItems.FORGED_IRON_INGOT))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExplorersOfLegends.MOD_ID, "explorers_of_legends_combat"))
                    .title(Component.translatable("creativetab.explorers_of_legends.explorers_of_legends_ingredients"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CrucibleItems.CURCIBLE);
                        output.accept(CrucibleItems.FORGED_IRON_CURCIBLE);
                        output.accept(ForgedIronItems.FORGED_IRON_NUGGET);
                        output.accept(ForgedIronItems.FORGED_IRON_INGOT);
                        output.accept(ForgedIronItems.FORGED_IRON_SHEET);
                        output.accept(ForgedIronItems.FORGED_IRON_STICK);
                        output.accept(ForgedIronItems.FORGED_IRON_STRING);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}