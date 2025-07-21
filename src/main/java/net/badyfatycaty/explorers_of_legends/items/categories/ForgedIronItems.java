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

    // Then register all items in a static block
    public static void registerParts() {
        // Register hot items first since they don't depend on the normal items yet
        FORGED_IRON_NUGGET_HOT = ITEMS.register("forged_iron_nugget_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_NUGGET.get().getDefaultInstance()));

        FORGED_IRON_INGOT_HOT = ITEMS.register("forged_iron_ingot_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_INGOT.get().getDefaultInstance()));

        FORGED_IRON_SHEET_HOT = ITEMS.register("forged_iron_sheet_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_SHEET.get().getDefaultInstance()));

        FORGED_IRON_STICK_HOT = ITEMS.register("forged_iron_stick_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_STICK.get().getDefaultInstance()));

        FORGED_IRON_STRING_HOT = ITEMS.register("forged_iron_string_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_STRING.get().getDefaultInstance()));

        FORGED_IRON_SCRAP_HOT = ITEMS.register("forged_iron_scrap_hot",
                () -> new HotItem(new Item.Properties(), 120, () -> FORGED_IRON_SCRAP.get().getDefaultInstance()));

        // Then register normal items that reference the hot items
        FORGED_IRON_NUGGET = ITEMS.register("forged_iron_nugget",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_NUGGET_HOT.get().getDefaultInstance()));

        FORGED_IRON_INGOT = ITEMS.register("forged_iron_ingot",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_INGOT_HOT.get().getDefaultInstance()));

        FORGED_IRON_SHEET = ITEMS.register("forged_iron_sheet",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_SHEET_HOT.get().getDefaultInstance()));

        FORGED_IRON_STICK = ITEMS.register("forged_iron_stick",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_STICK_HOT.get().getDefaultInstance()));

        FORGED_IRON_STRING = ITEMS.register("forged_iron_string",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_STRING_HOT.get().getDefaultInstance()));

        FORGED_IRON_SCRAP = ITEMS.register("forged_iron_scrap",
                () -> new HeatableItem(new Item.Properties(), () -> FORGED_IRON_SCRAP_HOT.get().getDefaultInstance()));
    }






    public static final DeferredItem<Item> FORGED_IRON_AXE = ITEMS.register("forged_iron_axe",
            () -> new EoLAxeItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_CLAYMORE = ITEMS.register("forged_iron_claymore",
            () -> new EoLClaymoreItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_DAGGER = ITEMS.register("forged_iron_dagger",
            () -> new EoLDaggerItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_DOUBLE_AXE = ITEMS.register("forged_iron_double_axe",
            () -> new EoLDoubleAxeItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_GLAIVE = ITEMS.register("forged_iron_glaive",
            () -> new EoLGlaiveItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_SCYTHE = ITEMS.register("forged_iron_scythe",
            () -> new EoLScytheItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_SICKLE = ITEMS.register("forged_iron_sickle",
            () -> new EoLSickleItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_SWORD = ITEMS.register("forged_iron_sword",
            () -> new EoLSwordItem(ModToolTiers.FORGED_IRON, new Item.Properties()));




    public static final DeferredItem<Item> FORGED_IRON_KATANA = ITEMS.register("forged_iron_katana",
            () -> new EoLKatanaItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_CHAKRAM = ITEMS.register("forged_iron_chakram",
            () -> new EoLChakramItem(ModToolTiers.FORGED_IRON, new Item.Properties()));

    public static final DeferredItem<Item> FORGED_IRON_WARGLAIVE = ITEMS.register("forged_iron_warglaive",
            () -> new EoLWarglaiveItem(ModToolTiers.FORGED_IRON, new Item.Properties()));



    public static final DeferredItem<Item> FORGED_IRON_HOE = ITEMS.register("forged_iron_hoe",
            () -> new HoeItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.FORGED_IRON, 0.0F, -3.0F))));

    public static final DeferredItem<Item> FORGED_IRON_MACE = ITEMS.register("forged_iron_mace",
            () -> new ModMaceItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(ModMaceItem.createAttributes(ModToolTiers.FORGED_IRON, 0.5F, -3.4F))));

    public static final DeferredItem<Item> FORGED_IRON_PICKAXE = ITEMS.register("forged_iron_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.FORGED_IRON, 1.0F, -2.8F))));

    public static final DeferredItem<Item> FORGED_IRON_SHOVEL = ITEMS.register("forged_iron_shovel",
            () -> new ShovelItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.FORGED_IRON, 1.5F, -3.0F))));

    public static final DeferredItem<Item> FORGED_IRON_SHIELD = ITEMS.register("forged_iron_shield",
            () -> new ModShieldItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(ModShieldItem.createAttributes(ModToolTiers.FORGED_IRON, 1.0F, -3.2F))));

    public static final DeferredItem<Item> FORGED_IRON_BOW = ITEMS.register("forged_iron_bow",
            () -> new ModBowItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(ModBowItem.createAttributes(ModToolTiers.FORGED_IRON, 1F, 1F, -3F))));

//    public static final DeferredItem<Item> FORGED_IRON_CROSSBOW = ITEMS.register("forged_iron_crossbow",
//            () -> new ModCrossbowItem(ModToolTiers.FORGED_IRON, new Item.Properties()
//                    .attributes(ModCrossbowItem.createAttributes(ModToolTiers.FORGED_IRON, 1.2F, 1.1F, -3F))));

    public static final DeferredItem<Item> FORGED_IRON_SPEAR = ITEMS.register("forged_iron_spear",
            () -> new SpearItem(ModToolTiers.FORGED_IRON, new Item.Properties()
                    .attributes(SpearItem.createAttributes(ModToolTiers.FORGED_IRON, 2.5F, -2.8F))));



    public static void register(IEventBus eventBus) {
        registerParts();
        ITEMS.register(eventBus);
    }
}
