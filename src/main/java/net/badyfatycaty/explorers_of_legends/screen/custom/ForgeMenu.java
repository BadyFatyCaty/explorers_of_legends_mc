package net.badyfatycaty.explorers_of_legends.screen.custom;

import net.badyfatycaty.explorers_of_legends.block.ModBlocks;
import net.badyfatycaty.explorers_of_legends.block.entity.ForgeBlockEntity;
import net.badyfatycaty.explorers_of_legends.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class ForgeMenu extends AbstractContainerMenu {
    public final ForgeBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    // Custom slot class that only allows 1 item
    private static class SingleItemSlot extends SlotItemHandler {
        public SingleItemSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public int getMaxStackSize() {
            return 1;
        }

        @Override
        public int getMaxStackSize(ItemStack stack) {
            return 1;
        }
    }

    public ForgeMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public ForgeMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FORGE_MENU.get(), pContainerId);
        checkContainerSize(inv, 22);
        this.blockEntity = ((ForgeBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        // Top row - 9 slots (0-8)
        for (int col = 0; col < 9; col++) {
            this.addSlot(new SingleItemSlot(blockEntity.itemHandler, col, 8 + col * 18, 18));
        }

        // Middle row - 6 slots (9-14)
        // Left side (9-11) - 3 slots
        for (int col = 0; col < 3; col++) {
            this.addSlot(new SingleItemSlot(blockEntity.itemHandler, 9 + col, 8 + col * 18, 36));
        }
        // Right side (12-14) - 3 slots
        for (int col = 3; col < 6; col++) {
            this.addSlot(new SingleItemSlot(blockEntity.itemHandler, 9 + col, 62 + col * 18, 36));
        }

        // Bottom row - 6 slots (15-20)
        // Left side (15-17) - 3 slots
        for (int col = 0; col < 3; col++) {
            this.addSlot(new SingleItemSlot(blockEntity.itemHandler, 15 + col, 8 + col * 18, 54));
        }
        // Right side (18-20) - 3 slots
        for (int col = 3; col < 6; col++) {
            this.addSlot(new SingleItemSlot(blockEntity.itemHandler, 15 + col, 62 + col * 18, 54));
        }

        // Fuel slot (21) - centered
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 21, 80, 54));

        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        addDataSlots(data);
    }

    public boolean hasFuel() {
        return data.get(2) > 0;
    }

    public int getScaledBurnProgress() {
        int burn = this.data.get(2);
        int maxBurn = this.data.get(3);
        int firePixelSize = 14;

        return maxBurn > 0 && burn > 0 ? (burn * firePixelSize) / maxBurn : 0;
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 22;

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // Coming from player inventory - only allow moving 1 item to single-item slots
            if (sourceStack.getCount() > 1 && pIndex >= TE_INVENTORY_FIRST_SLOT_INDEX && pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + 21) {
                // For single-item slots, split the stack
                ItemStack singleItem = sourceStack.split(1);
                if (!moveItemStackTo(singleItem, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + 21, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
                    return ItemStack.EMPTY;
                }
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // Coming from TE inventory - can move freely to player inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.FORGE.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}