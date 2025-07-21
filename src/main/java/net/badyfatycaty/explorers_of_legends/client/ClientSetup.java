package net.badyfatycaty.explorers_of_legends.client;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.items.ModItems;
import net.badyfatycaty.explorers_of_legends.items.custom.DNAItem;
import net.minecraft.client.color.item.ItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = ExplorersOfLegends.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
        ItemColor dnaColorHandler = (stack, layer) -> {
            if (stack.getItem() instanceof DNAItem dnaItem) {
                return dnaItem.getColor(layer);
            }
            return 0xFFFFFF;
        };

        event.register(dnaColorHandler
        );
    }
}
