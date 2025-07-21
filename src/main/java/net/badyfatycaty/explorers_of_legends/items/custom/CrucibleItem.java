package net.badyfatycaty.explorers_of_legends.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CrucibleItem extends Item {

    public CrucibleItem(Properties properties, int maxDurability) {
        super(properties.durability(maxDurability));
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int durabilityLeft = stack.getMaxDamage() - stack.getDamageValue();
        int maxDurability = stack.getMaxDamage();

        tooltipComponents.add(Component.literal(""));
        MutableComponent textComponent = Component.translatable("item.explorers_of_legends.crucible.tooltip").withStyle(ChatFormatting.WHITE);
        MutableComponent durabilityComponent = Component.literal(": ").withStyle(ChatFormatting.WHITE)
                .append(Component.literal(durabilityLeft + "/" + maxDurability).withStyle(ChatFormatting.RED));
        tooltipComponents.add(textComponent.append(durabilityComponent));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 0xf4680b;
    }
}