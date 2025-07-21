package net.badyfatycaty.explorers_of_legends.items.custom;

import net.minecraft.world.item.Item;

public class DNAItem extends Item {
    private final int baseColor;
    private final int overlayColor;

    public DNAItem(int baseColor, int overlayColor, Properties properties) {
        super(properties);
        this.baseColor = baseColor;
        this.overlayColor = overlayColor;
    }

    public int getColor(int tintIndex) {
        return tintIndex == 0 ? baseColor : tintIndex == 1 ? overlayColor : 0xFFFFFF;
    }
}