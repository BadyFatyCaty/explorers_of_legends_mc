package net.badyfatycaty.explorers_of_legends.attributes.spirit.entity;

import net.badyfatycaty.explorers_of_legends.ExplorersOfLegends;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SpiritMovementSpeed {
    public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, ExplorersOfLegends.MODID);
    public static final DeferredHolder<Attribute, Attribute> SPIRIT_MOVEMENT_SPEED = REGISTRY.register("spirit_movement_speed", () -> new RangedAttribute("attribute.explorers_of_legends.spirit_movement_speed",
            0.7, 0, 1024).setSyncable(true).setSentiment(Attribute.Sentiment.POSITIVE));

    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, SPIRIT_MOVEMENT_SPEED);
    }
}
