package net.badyfatycaty.explorers_of_legends.attributes.element.nature;

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
public class NatureDamage {
    public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, ExplorersOfLegends.MODID);
    public static final DeferredHolder<Attribute, Attribute> NATURE_DAMAGE = REGISTRY.register("nature_damage", () -> new RangedAttribute("attribute.explorers_of_legends.nature_damage",
            0, 0, 2048).setSyncable(true).setSentiment(Attribute.Sentiment.POSITIVE));

    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(entity -> event.add(entity, NATURE_DAMAGE));
    }
}
