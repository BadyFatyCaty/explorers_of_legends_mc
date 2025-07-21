package net.badyfatycaty.explorers_of_legends.items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.function.Supplier;

public class HeatableItem extends Item {
    private Supplier<ItemStack> heatableItem;


    public HeatableItem(Properties properties, Supplier<ItemStack> heatableItem) {
        super(properties);
        this.heatableItem = heatableItem;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(""));
        MutableComponent textComponent = Component.translatable("item.explorers_of_legends.heatable.tooltip").withStyle(ChatFormatting.GRAY);
        tooltipComponents.add(textComponent);
    }

    public ItemStack getHeatedItem() { return heatableItem.get(); }

}