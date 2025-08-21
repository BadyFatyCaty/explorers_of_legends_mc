package net.badyfatycaty.explorers_of_legends.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;

public class CastingSandBlock extends FallingBlock {
    public static final MapCodec<CastingSandBlock> CODEC = simpleCodec(CastingSandBlock::new);

    public CastingSandBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }
}

