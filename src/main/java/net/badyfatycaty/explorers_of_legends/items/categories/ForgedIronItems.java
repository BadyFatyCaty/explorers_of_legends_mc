package net.badyfatycaty.explorers_of_legends.items.categories;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.items.ModToolTiers;
import net.badyfatycaty.explorers_of_legends.items.custom.HeatableItem;
import net.badyfatycaty.explorers_of_legends.items.custom.HotItem;
import net.badyfatycaty.explorers_of_legends.items.custom.weapon_types.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ForgedIronItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExplorersOfLegends.MOD_ID);


    // First declare all fields without initialization
    public static DeferredItem<Item> FORGED_IRON_NUGGET;
    public static DeferredItem<Item> FORGED_IRON_NUGGET_HOT;

    public static DeferredItem<Item> FORGED_IRON_INGOT;
    public static DeferredItem<Item> FORGED_IRON_INGOT_HOT;

    public static DeferredItem<Item> FORGED_IRON_SHEET;
    public static DeferredItem<Item> FORGED_IRON_SHEET_HOT;

    public static DeferredItem<Item> FORGED_IRON_STICK;
    public static DeferredItem<Item> FORGED_IRON_STICK_HOT;

    public static DeferredItem<Item> FORGED_IRON_STRING;
    public static DeferredItem<Item> FORGED_IRON_STRING_HOT;

    public static DeferredItem<Item> FORGED_IRON_SCRAP;
    public static DeferredItem<Item> FORGED_IRON_SCRAP_HOT;

    public static DeferredItem<Item> TINY_BLOCK_OF_FORGED_IRON;
    public static DeferredItem<Item> TINY_BLOCK_OF_FORGED_IRON_HOT;

    public static DeferredItem<Item> SMALL_BLOCK_OF_FORGED_IRON;
    public static DeferredItem<Item> SMALL_BLOCK_OF_FORGED_IRON_HOT;

    public static DeferredItem<Item> MEDIUM_BLOCK_OF_FORGED_IRON;
    public static DeferredItem<Item> MEDIUM_BLOCK_OF_FORGED_IRON_HOT;

    public static DeferredItem<Item> LARGE_BLOCK_OF_FORGED_IRON;
    public static DeferredItem<Item> LARGE_BLOCK_OF_FORGED_IRON_HOT;

    public static DeferredItem<Item> HUGE_BLOCK_OF_FORGED_IRON;
    public static DeferredItem<Item> HUGE_BLOCK_OF_FORGED_IRON_HOT;



    public static DeferredItem<Item> FORGED_IRON_AXE_HEAD;
    public static DeferredItem<Item> FORGED_IRON_AXE_HEAD_HOT;

    public static DeferredItem<Item> FORGED_IRON_BOW_STAVE;
    public static DeferredItem<Item> FORGED_IRON_BOW_STAVE_HOT;

    public static DeferredItem<Item> FORGED_IRON_CHAKRAM_BLADE;
    public static DeferredItem<Item> FORGED_IRON_CHAKRAM_BLADE_HOT;

    public static DeferredItem<Item> FORGED_IRON_CLAYMORE_BLADE;
    public static DeferredItem<Item> FORGED_IRON_CLAYMORE_BLADE_HOT;
    public static DeferredItem<Item> FORGED_IRON_CLAYMORE_GUARD;
    public static DeferredItem<Item> FORGED_IRON_CLAYMORE_GUARD_HOT;

    public static DeferredItem<Item> FORGED_IRON_DAGGER_BLADE;
    public static DeferredItem<Item> FORGED_IRON_DAGGER_BLADE_HOT;

    public static DeferredItem<Item> FORGED_IRON_DOUBLE_AXE_HEAD;
    public static DeferredItem<Item> FORGED_IRON_DOUBLE_AXE_HEAD_HOT;

    public static DeferredItem<Item> FORGED_IRON_GLAIVE_BLADE;
    public static DeferredItem<Item> FORGED_IRON_GLAIVE_BLADE_HOT;
    public static DeferredItem<Item> FORGED_IRON_GLAIVE_POMMEL;
    public static DeferredItem<Item> FORGED_IRON_GLAIVE_POMMEL_HOT;

    public static DeferredItem<Item> FORGED_IRON_GREATSWORD_BLADE;
    public static DeferredItem<Item> FORGED_IRON_GREATSWORD_BLADE_HOT;
    public static DeferredItem<Item> FORGED_IRON_GREATSWORD_GUARD;
    public static DeferredItem<Item> FORGED_IRON_GREATSWORD_GUARD_HOT;

    // Then register all items in a static block
    public static void registerParts() {
        FORGED_IRON_NUGGET_HOT = ITEMS.register("forged_iron_nugget_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_NUGGET.get().getDefaultInstance()));
        FORGED_IRON_NUGGET = ITEMS.register("forged_iron_nugget",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_NUGGET_HOT.get().getDefaultInstance()));

        FORGED_IRON_INGOT_HOT = ITEMS.register("forged_iron_ingot_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_INGOT.get().getDefaultInstance()));
        FORGED_IRON_INGOT = ITEMS.register("forged_iron_ingot",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_INGOT_HOT.get().getDefaultInstance()));

        FORGED_IRON_SHEET_HOT = ITEMS.register("forged_iron_sheet_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_SHEET.get().getDefaultInstance()));
        FORGED_IRON_SHEET = ITEMS.register("forged_iron_sheet",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_SHEET_HOT.get().getDefaultInstance()));

        FORGED_IRON_STICK_HOT = ITEMS.register("forged_iron_stick_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_STICK.get().getDefaultInstance()));
        FORGED_IRON_STICK = ITEMS.register("forged_iron_stick",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_STICK_HOT.get().getDefaultInstance()));

        FORGED_IRON_STRING_HOT = ITEMS.register("forged_iron_string_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_STRING.get().getDefaultInstance()));
        FORGED_IRON_STRING = ITEMS.register("forged_iron_string",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_STRING_HOT.get().getDefaultInstance()));

        FORGED_IRON_SCRAP_HOT = ITEMS.register("forged_iron_scrap_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_SCRAP.get().getDefaultInstance()));
        FORGED_IRON_SCRAP = ITEMS.register("forged_iron_scrap",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_SCRAP_HOT.get().getDefaultInstance()));

        TINY_BLOCK_OF_FORGED_IRON_HOT = ITEMS.register("tiny_block_of_forged_iron_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> TINY_BLOCK_OF_FORGED_IRON.get().getDefaultInstance()));
        TINY_BLOCK_OF_FORGED_IRON = ITEMS.register("tiny_block_of_forged_iron",
                () -> new HeatableItem(new Item.Properties(), () -> TINY_BLOCK_OF_FORGED_IRON_HOT.get().getDefaultInstance()));

        SMALL_BLOCK_OF_FORGED_IRON_HOT = ITEMS.register("small_block_of_forged_iron_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> SMALL_BLOCK_OF_FORGED_IRON.get().getDefaultInstance()));
        SMALL_BLOCK_OF_FORGED_IRON = ITEMS.register("small_block_of_forged_iron",
                () -> new HeatableItem(new Item.Properties(), () -> SMALL_BLOCK_OF_FORGED_IRON_HOT.get().getDefaultInstance()));

        MEDIUM_BLOCK_OF_FORGED_IRON_HOT = ITEMS.register("medium_block_of_forged_iron_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> MEDIUM_BLOCK_OF_FORGED_IRON.get().getDefaultInstance()));
        MEDIUM_BLOCK_OF_FORGED_IRON = ITEMS.register("medium_block_of_forged_iron",
                () -> new HeatableItem(new Item.Properties(), () -> MEDIUM_BLOCK_OF_FORGED_IRON_HOT.get().getDefaultInstance()));

        LARGE_BLOCK_OF_FORGED_IRON_HOT = ITEMS.register("large_block_of_forged_iron_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> LARGE_BLOCK_OF_FORGED_IRON.get().getDefaultInstance()));
        LARGE_BLOCK_OF_FORGED_IRON = ITEMS.register("large_block_of_forged_iron",
                () -> new HeatableItem(new Item.Properties(), () -> LARGE_BLOCK_OF_FORGED_IRON_HOT.get().getDefaultInstance()));

        HUGE_BLOCK_OF_FORGED_IRON_HOT = ITEMS.register("huge_block_of_forged_iron_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> HUGE_BLOCK_OF_FORGED_IRON.get().getDefaultInstance()));
        HUGE_BLOCK_OF_FORGED_IRON = ITEMS.register("huge_block_of_forged_iron",
                () -> new HeatableItem(new Item.Properties(), () -> HUGE_BLOCK_OF_FORGED_IRON_HOT.get().getDefaultInstance()));


        FORGED_IRON_AXE_HEAD_HOT = ITEMS.register("forged_iron_axe_head_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_AXE_HEAD.get().getDefaultInstance()));
        FORGED_IRON_AXE_HEAD = ITEMS.register("forged_iron_axe_head",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_AXE_HEAD_HOT.get().getDefaultInstance()));

        FORGED_IRON_BOW_STAVE_HOT = ITEMS.register("forged_iron_bow_stave_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_BOW_STAVE.get().getDefaultInstance()));
        FORGED_IRON_BOW_STAVE = ITEMS.register("forged_iron_bow_stave",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_BOW_STAVE_HOT.get().getDefaultInstance()));

        FORGED_IRON_CHAKRAM_BLADE_HOT = ITEMS.register("forged_iron_chakram_blade_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_CHAKRAM_BLADE.get().getDefaultInstance()));
        FORGED_IRON_CHAKRAM_BLADE = ITEMS.register("forged_iron_chakram_blade",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_CHAKRAM_BLADE_HOT.get().getDefaultInstance()));

        FORGED_IRON_CLAYMORE_BLADE_HOT = ITEMS.register("forged_iron_claymore_blade_hot",
                () -> new HotItem(new Item.Properties(), 120,
                        () -> FORGED_IRON_CLAYMORE_BLADE.get().getDefaultInstance()));
        FORGED_IRON_CLAYMORE_BLADE = ITEMS.register("forged_iron_claymore_blade",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_CLAYMORE_BLADE_HOT.get().getDefaultInstance()));
        FORGED_IRON_CLAYMORE_GUARD_HOT = ITEMS.register("forged_iron_claymore_guard_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_CLAYMORE_GUARD.get().getDefaultInstance()));
        FORGED_IRON_CLAYMORE_GUARD = ITEMS.register("forged_iron_claymore_guard",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_CLAYMORE_GUARD_HOT.get().getDefaultInstance()));

        FORGED_IRON_DAGGER_BLADE_HOT = ITEMS.register("forged_iron_dagger_blade_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_DAGGER_BLADE.get().getDefaultInstance()));
        FORGED_IRON_DAGGER_BLADE = ITEMS.register("forged_iron_dagger_blade",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_DAGGER_BLADE_HOT.get().getDefaultInstance()));

        FORGED_IRON_DOUBLE_AXE_HEAD_HOT = ITEMS.register("forged_iron_double_axe_head_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_DOUBLE_AXE_HEAD.get().getDefaultInstance()));
        FORGED_IRON_DOUBLE_AXE_HEAD = ITEMS.register("forged_iron_double_axe_head",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_DOUBLE_AXE_HEAD_HOT.get().getDefaultInstance()));

        FORGED_IRON_GLAIVE_BLADE_HOT = ITEMS.register("forged_iron_glaive_blade_hot",
                () -> new HotItem(new Item.Properties(), 120,
                        () -> FORGED_IRON_GLAIVE_BLADE.get().getDefaultInstance()));
        FORGED_IRON_GLAIVE_BLADE = ITEMS.register("forged_iron_glaive_blade",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_GLAIVE_BLADE_HOT.get().getDefaultInstance()));
        FORGED_IRON_GLAIVE_POMMEL_HOT = ITEMS.register("forged_iron_glaive_pommel_hot",
                () -> new HotItem(new Item.Properties(), 120,
                        () -> FORGED_IRON_GLAIVE_POMMEL.get().getDefaultInstance()));
        FORGED_IRON_GLAIVE_POMMEL = ITEMS.register("forged_iron_glaive_pommel",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_GLAIVE_POMMEL_HOT.get().getDefaultInstance()));


        FORGED_IRON_GREATSWORD_BLADE_HOT = ITEMS.register("forged_iron_greatsword_blade_hot",
                () -> new HotItem(new Item.Properties(), 120,
                        () -> FORGED_IRON_GREATSWORD_BLADE.get().getDefaultInstance()));
        FORGED_IRON_GREATSWORD_BLADE = ITEMS.register("forged_iron_greatsword_blade",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_GREATSWORD_BLADE_HOT.get().getDefaultInstance()));
        FORGED_IRON_GREATSWORD_GUARD_HOT = ITEMS.register("forged_iron_greatsword_guard_hot",
                () -> new HotItem(new Item.Properties(), 120,
                        () -> FORGED_IRON_GREATSWORD_GUARD.get().getDefaultInstance()));
        FORGED_IRON_GREATSWORD_GUARD = ITEMS.register("forged_iron_greatsword_guard",
                () -> new HeatableItem(new Item.Properties()
                        .stacksTo(1)
                        , () -> FORGED_IRON_GREATSWORD_GUARD_HOT.get().getDefaultInstance()));
    }





    public static final DeferredItem<Item> FORGED_IRON_SHOVEL = ITEMS.register("forged_iron_shovel",
            () -> new ShovelItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.FORGED_IRON, 1.5F, -3.0F))));

    public static final DeferredItem<Item> FORGED_IRON_PICKAXE = ITEMS.register("forged_iron_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.FORGED_IRON, 1.0F, -2.8F))));

    public static final DeferredItem<Item> FORGED_IRON_AXE = ITEMS.register("forged_iron_axe",
            () -> new EoLAxeItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_BOW = ITEMS.register("forged_iron_bow",
            () -> new ModBowItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(ModBowItem.createAttributes(ModToolTiers.FORGED_IRON, 1F, 1F, -3F))));

    public static final DeferredItem<Item> FORGED_IRON_HOE = ITEMS.register("forged_iron_hoe",
            () -> new HoeItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.FORGED_IRON, 0.0F, -3.0F))));

    public static final DeferredItem<Item> FORGED_IRON_CHAKRAM = ITEMS.register("forged_iron_chakram",
            () -> new EoLChakramItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_CLAYMORE = ITEMS.register("forged_iron_claymore",
            () -> new EoLClaymoreItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_DAGGER = ITEMS.register("forged_iron_dagger",
            () -> new EoLDaggerItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_DOUBLE_AXE = ITEMS.register("forged_iron_double_axe",
            () -> new EoLDoubleAxeItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_GLAIVE = ITEMS.register("forged_iron_glaive",
            () -> new EoLGlaiveItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_GREATSWORD = ITEMS.register("forged_iron_greatsword",
            () -> new EoLClaymoreItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_KATANA = ITEMS.register("forged_iron_katana",
            () -> new EoLKatanaItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_MACE = ITEMS.register("forged_iron_mace",
            () -> new EoLMaceItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(EoLMaceItem.createAttributes(ModToolTiers.FORGED_IRON, 0.5F, -3.4F))));

    public static final DeferredItem<Item> FORGED_IRON_SCYTHE = ITEMS.register("forged_iron_scythe",
            () -> new EoLScytheItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_SICKLE = ITEMS.register("forged_iron_sickle",
            () -> new EoLSickleItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_SWORD = ITEMS.register("forged_iron_sword",
            () -> new EoLSwordItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_SHIELD = ITEMS.register("forged_iron_shield",
            () -> new EoLShieldItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(EoLShieldItem.createAttributes(ModToolTiers.FORGED_IRON, 1.0F, -3.2F))));

    public static final DeferredItem<Item> FORGED_IRON_SPEAR = ITEMS.register("forged_iron_spear",
            () -> new SpearItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(SpearItem.createAttributes(ModToolTiers.FORGED_IRON, 2.5F, -2.8F))));

    public static final DeferredItem<Item> FORGED_IRON_WARGLAIVE = ITEMS.register("forged_iron_warglaive",
            () -> new EoLWarglaiveItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_LONGBOW = ITEMS.register("forged_iron_longbow",
            () -> new ModBowItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(ModBowItem.createAttributes(ModToolTiers.FORGED_IRON, 2F, 2F, -3.2F))));
                    //TODO: Make draw speed affect the draw speed of the item.




    public static final DeferredItem<Item> FORGED_IRON_HANDLE = ITEMS.register("forged_iron_handle",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_BOWSTRING = ITEMS.register("forged_iron_bowstring",
            () -> new Item(new Item.Properties()));


//    public static final DeferredItem<Item> FORGED_IRON_CROSSBOW = ITEMS.register("forged_iron_crossbow",
//            () -> new ModCrossbowItem(ModToolTiers.FORGED_IRON, new Item.Properties()
//                    .attributes(ModCrossbowItem.createAttributes(ModToolTiers.FORGED_IRON, 1.2F, 1.1F, -3F))));



    public static void register(IEventBus eventBus) {
        registerParts();
        ITEMS.register(eventBus);
    }
}
