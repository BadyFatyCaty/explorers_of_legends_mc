package net.badyfatycaty.explorers_of_legends.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.badyfatycaty.explorers_of_legends.block.entity.ForgeBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class ForgeBlockRenderer implements BlockEntityRenderer<ForgeBlockEntity> {

    private final ItemRenderer itemRenderer;

    public ForgeBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = Minecraft.getInstance().getItemRenderer();
    }

    @Override
    public void render(ForgeBlockEntity blockEntity, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int combinedLight, int combinedOverlay) {

        poseStack.pushPose();

        // Get block's facing direction
        var state = blockEntity.getBlockState();
        var facing = state.getValue(net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING);

        // Translate to block center and rotate based on facing
        poseStack.translate(0.5, 0.45, 0.5);
        switch (facing) {
            case NORTH -> poseStack.mulPose(Axis.YP.rotationDegrees(0));
            case SOUTH -> poseStack.mulPose(Axis.YP.rotationDegrees(180));
            case WEST  -> poseStack.mulPose(Axis.YP.rotationDegrees(90));
            case EAST  -> poseStack.mulPose(Axis.YP.rotationDegrees(-90));
        }


        // Render ingredient slots (1-9 in a 3x3 grid)
        // Render ingredient slots (use inventory slots 1–9; slot 0 is fuel)
        for (int grid = 0; grid < 9; grid++) {
            int slot = 1 + grid; // shift by 1 because fuel is at 0
            if (slot >= blockEntity.itemHandler.getSlots()) break;

            ItemStack stack = blockEntity.itemHandler.getStackInSlot(slot);
            if (stack.isEmpty()) continue;

            poseStack.pushPose();

            int x = grid % 3;
            int y = grid / 3;
            poseStack.translate((x - 1) * 0.25, 0.0, (y - 1) * 0.25);
            poseStack.scale(0.25f, 0.25f, 0.25f);

            // Use slot as a stable render seed to avoid z-fighting flicker between frames
            itemRenderer.renderStatic(
                    stack,
                    ItemDisplayContext.FIXED,
                    combinedLight,
                    combinedOverlay,
                    poseStack,
                    buffer,
                    blockEntity.getLevel(),
                    slot // seed
            );

            poseStack.popPose();
        }

        // Render fuel slot (slot 0)
        ItemStack fuelSlot = blockEntity.itemHandler.getStackInSlot(0);
        if (!fuelSlot.isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0, -0.25, -0.25);
            poseStack.scale(0.25f, 0.25f, 0.25f);
            itemRenderer.renderStatic(fuelSlot, ItemDisplayContext.FIXED, combinedLight, combinedOverlay, poseStack, buffer, blockEntity.getLevel(), 1);
            poseStack.popPose();
        }

        poseStack.popPose();
    }

}
