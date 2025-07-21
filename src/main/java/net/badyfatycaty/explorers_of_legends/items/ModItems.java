package net.badyfatycaty.explorers_of_legends.items;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.items.custom.DNAItem;
import net.badyfatycaty.explorers_of_legends.items.custom.weapon_types.EoLChakramItem;
import net.badyfatycaty.explorers_of_legends.items.custom.weapon_types.EoLKatanaItem;
import net.badyfatycaty.explorers_of_legends.items.custom.weapon_types.EoLSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExplorersOfLegends.MOD_ID);

    public static final DeferredItem<Item> COMMON = ITEMS.register("common",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNCOMMON = ITEMS.register("uncommon",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RARE = ITEMS.register("rare",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EPIC = ITEMS.register("epic",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LEGENDARY = ITEMS.register("legendary",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MYTHIC = ITEMS.register("mythic",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> UNIQUE = ITEMS.register("unique",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> KATANA = ITEMS.register("katana",
            () -> new EoLKatanaItem(Tiers.DIAMOND, new Item.Properties()));

    public static final DeferredItem<Item> ELEMENTAL_DISK = ITEMS.register("elemental_disk",
            () -> new EoLChakramItem(Tiers.NETHERITE, new Item.Properties()));

    public static final DeferredItem<Item> CRYSTALLIZED_MAGMA = ITEMS.register("crystallized_magma",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
