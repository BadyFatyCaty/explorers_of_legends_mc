package net.badyfatycaty.explorers_of_legends.attributes.physical_dmg.slicing;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SlicingResistance {
    public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, ExplorersOfLegends.MODID);
    public static final DeferredHolder<Attribute, Attribute> SLICING_RESISTANCE = REGISTRY.register("slicing_resistance", () -> new RangedAttribute("attribute.explorers_of_legends.slicing_resistance",
            0, 0, 2048).setSyncable(true).setSentiment(Attribute.Sentiment.POSITIVE));

    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(entity -> event.add(entity, SLICING_RESISTANCE));
    }
}
