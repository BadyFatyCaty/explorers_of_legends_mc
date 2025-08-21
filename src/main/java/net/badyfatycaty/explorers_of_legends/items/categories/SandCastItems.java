package net.badyfatycaty.explorers_of_legends.items.categories;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.items.custom.CastItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SandCastItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExplorersOfLegends.MOD_ID);

    public static final DeferredItem<Item> BLANK_SAND_CAST = ITEMS.register("blank_sand_cast",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SAND_NUGGET_CAST = ITEMS.register("sand_nugget_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_INGOT_CAST = ITEMS.register("sand_ingot_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_STICK_CAST = ITEMS.register("sand_stick_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_STRING_CAST = ITEMS.register("sand_string_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_AXE_HEAD_CAST = ITEMS.register("sand_axe_head_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_BOW_STAVE_CAST = ITEMS.register("sand_bow_stave_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_CHAKRAM_BLADE_CAST = ITEMS.register("sand_chakram_blade_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_CLAYMORE_BLADE_CAST = ITEMS.register("sand_claymore_blade_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_CLAYMORE_GUARD_CAST = ITEMS.register("sand_claymore_guard_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_DAGGER_BLADE_CAST = ITEMS.register("sand_dagger_blade_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_DOUBLE_AXE_HEAD_CAST = ITEMS.register("sand_double_axe_head_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_GLAIVE_BLADE_CAST = ITEMS.register("sand_glaive_blade_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_GLAIVE_POMMEL_CAST = ITEMS.register("sand_glaive_pommel_cast",
            () -> new CastItem(new Item.Properties()));



    public static final DeferredItem<Item> SAND_GREATSWORD_BLADE_CAST = ITEMS.register("sand_greatsword_blade_cast",
            () -> new CastItem(new Item.Properties()));

    public static final DeferredItem<Item> SAND_GREATSWORD_GUARD_CAST = ITEMS.register("sand_greatsword_guard_cast",
            () -> new CastItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
