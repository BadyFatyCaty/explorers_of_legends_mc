package net.badyfatycaty.explorers_of_legends.block.custom;

import com.mojang.serialization.MapCodec;
import net.badyfatycaty.explorers_of_legends.block.entity.CastingTableBlockEntity;
import net.badyfatycaty.explorers_of_legends.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CastingTableBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final MapCodec<CastingTableBlock> CODEC = simpleCodec(CastingTableBlock::new);

    public CastingTableBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape leg1 = Block.box(0, 0, 0, 4, 10, 4);
        VoxelShape leg2 = Block.box(12, 0, 0, 16, 10, 4);
        VoxelShape leg3 = Block.box(0, 0, 12, 4, 10, 16);
        VoxelShape leg4 = Block.box(12, 0, 12, 16, 10, 16);

        VoxelShape tabletop = Block.box(0, 10, 0, 16, 14, 16);

        // Outer rim box
        VoxelShape outer = Block.box(0, 10, 0, 16, 16, 16);
        // Inner hole cutout
        VoxelShape inner = Block.box(1, 10, 1, 15, 16, 15);
        VoxelShape rim = Shapes.join(outer, inner, BooleanOp.ONLY_FIRST);

        return Shapes.or(leg1, leg2, leg3, leg4, tabletop, rim);
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return getShape(state, world, pos, CollisionContext.empty());
    }



    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CastingTableBlockEntity(blockPos, blockState);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof CastingTableBlockEntity castingTableBlockEntity) {
                castingTableBlockEntity.drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos,
                                              Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof CastingTableBlockEntity castingTableBlockEntity) {
                ((ServerPlayer) pPlayer).openMenu(new SimpleMenuProvider(castingTableBlockEntity,
                        Component.translatable("block.explorers_of_legends.casting")), pPos);
            } else {
                throw new IllegalStateException("Forge Container provider is missing!");
            }
        }

        return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
        }

        return createTickerHelper(blockEntityType, ModBlockEntities.CASTING_TABLE_BE.get(),
                (lvl, pos, st, be) -> {
                    if (be instanceof CastingTableBlockEntity castingTableBlockEntity) {
                        castingTableBlockEntity.tick(lvl, pos, st);
                    }
                });
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}