package net.badyfatycaty.explorers_of_legends.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CastItem extends Item {

    public CastItem(Properties properties, int capacity, int uses) {
        super(properties
                .durability(capacity)
                .stacksTo(1)
        );
    }

    public CastItem(Properties properties) {
        super(properties
                .stacksTo(1)
        );
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }
}