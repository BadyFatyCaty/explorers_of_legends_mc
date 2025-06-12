package net.badyfatycaty.explorers_of_legends.items.categories;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.items.custom.CrucibleItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CrucibleItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExplorersOfLegends.MOD_ID);

    public static final DeferredItem<Item> CURCIBLE = ITEMS.register("crucible",
            () -> new CrucibleItem(new Item.Properties(), 0));

    public static final DeferredItem<Item> FORGED_IRON_CURCIBLE = ITEMS.register("molten_forged_iron_filled_crucible",
            () -> new CrucibleItem(new Item.Properties(), 5));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
