package net.badyfatycaty.explorers_of_legends.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
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

        // Position based on block orientation
        poseStack.translate(0.5, 0.45, 0.5);

        // Render ingredient slots (0–8 in a 3x3 grid)
        for (int i = 0; i < 9; i++) {
            ItemStack stack = blockEntity.itemHandler.getStackInSlot(i);
            if (!stack.isEmpty()) {
                poseStack.pushPose();

                // 3x3 grid layout (left-to-right, top-to-bottom)
                int x = i % 3;
                int y = i / 3;
                poseStack.translate((x - 1) * 0.25, 0.0, (y - 1) * 0.25);
                poseStack.scale(0.25f, 0.25f, 0.25f);

                itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, combinedLight, combinedOverlay, poseStack, buffer, blockEntity.getLevel(), 0);

                poseStack.popPose();
            }
        }

        // Render fuel slot (slot 21)
        ItemStack fuelSlot = blockEntity.itemHandler.getStackInSlot(21);
        if (!fuelSlot.isEmpty()) {
            poseStack.pushPose();

            // Render at around the center
            poseStack.translate(0, -0.25, -0.25);
            poseStack.scale(0.25f, 0.25f, 0.25f);
            itemRenderer.renderStatic(fuelSlot, ItemDisplayContext.FIXED, combinedLight, combinedOverlay, poseStack, buffer, blockEntity.getLevel(), 1);

            poseStack.popPose();
        }

        poseStack.popPose();
    }
}
