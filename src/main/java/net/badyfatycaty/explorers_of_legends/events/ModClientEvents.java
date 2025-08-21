package net.badyfatycaty.explorers_of_legends.events;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.badyfatycaty.explorers_of_legends.items.categories.ForgedIronItems;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

@EventBusSubscriber(modid = ExplorersOfLegends.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value =  Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onComputeFovModifierEvent(ComputeFovModifierEvent event) {
        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ForgedIronItems.FORGED_IRON_BOW.get() ||
                event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ForgedIronItems.FORGED_IRON_LONGBOW.get()) {
            float fovModifier = 1f;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float)ticksUsingItem / 20f;
            if(deltaTicks > 1f) {
                deltaTicks = 1f;
            } else {
                deltaTicks *= deltaTicks;
            }
            fovModifier *= 1f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
    }
}