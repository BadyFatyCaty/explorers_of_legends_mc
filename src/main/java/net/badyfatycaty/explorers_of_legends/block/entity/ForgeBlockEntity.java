package net.badyfatycaty.explorers_of_legends.block.entity;

import net.badyfatycaty.explorers_of_legends.items.custom.HeatableItem;
import net.badyfatycaty.explorers_of_legends.items.custom.HotItem;
import net.badyfatycaty.explorers_of_legends.screen.custom.ForgeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ForgeBlockEntity extends BlockEntity implements MenuProvider {
    public static boolean isFuel(ItemStack stack) {
        return     stack.is(Items.ACACIA_LOG) || stack.is(Items.BIRCH_LOG)
                || stack.is(Items.CHERRY_LOG) || stack.is(Items.JUNGLE_LOG)
                || stack.is(Items.OAK_LOG) || stack.is(Items.DARK_OAK_LOG)
                || stack.is(Items.MANGROVE_LOG) || stack.is(Items.SPRUCE_LOG)

                || stack.is(Items.STRIPPED_ACACIA_LOG) || stack.is(Items.STRIPPED_BIRCH_LOG)
                || stack.is(Items.STRIPPED_CHERRY_LOG) || stack.is(Items.STRIPPED_JUNGLE_LOG)
                || stack.is(Items.STRIPPED_OAK_LOG) || stack.is(Items.STRIPPED_DARK_OAK_LOG)
                || stack.is(Items.STRIPPED_MANGROVE_LOG) || stack.is(Items.STRIPPED_SPRUCE_LOG)

                || stack.is(Items.ACACIA_WOOD) || stack.is(Items.BIRCH_WOOD)
                || stack.is(Items.CHERRY_WOOD) || stack.is(Items.JUNGLE_WOOD)
                || stack.is(Items.OAK_WOOD) || stack.is(Items.DARK_OAK_WOOD)
                || stack.is(Items.MANGROVE_WOOD) || stack.is(Items.SPRUCE_WOOD)

                || stack.is(Items.STRIPPED_ACACIA_WOOD) || stack.is(Items.STRIPPED_BIRCH_WOOD)
                || stack.is(Items.STRIPPED_CHERRY_WOOD) || stack.is(Items.STRIPPED_JUNGLE_WOOD)
                || stack.is(Items.STRIPPED_OAK_WOOD) || stack.is(Items.STRIPPED_DARK_OAK_WOOD)
                || stack.is(Items.STRIPPED_MANGROVE_WOOD) || stack.is(Items.STRIPPED_SPRUCE_WOOD);
    }

    public final ItemStackHandler itemHandler = new ItemStackHandler(22) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }


        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            if (slot == FUEL_SLOT) {
                return isFuel(stack);
            }
            return true; // Allow all other slots to accept any item (can fine-tune later)
        }
    };

    private static final int FUEL_SLOT = 0;             // slot 0
    private static final int TOP_ROW_START = 1;         // tarts at 1
    private static final int TOP_ROW_END = 9;           // 1–9 (9 slots)
    private static final int MIDDLE_LEFT_START = 10;    // 10–12
    private static final int MIDDLE_LEFT_END = 12;
    private static final int MIDDLE_RIGHT_START = 13;   // 13–15
    private static final int MIDDLE_RIGHT_END = 15;
    private static final int BOTTOM_LEFT_START = 16;    // 16–18
    private static final int BOTTOM_LEFT_END = 18;
    private static final int BOTTOM_RIGHT_START = 19;   // 19–21
    private static final int BOTTOM_RIGHT_END = 21;


    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    public int burnTime = 0;
    private int maxBurnTime = 2400;

    public ForgeBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.FORGE_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> ForgeBlockEntity.this.progress;
                    case 1 -> ForgeBlockEntity.this.maxProgress;
                    case 2 -> ForgeBlockEntity.this.burnTime;
                    case 3 -> ForgeBlockEntity.this.maxBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> ForgeBlockEntity.this.progress = value;
                    case 1 -> ForgeBlockEntity.this.maxProgress = value;
                    case 2 -> ForgeBlockEntity.this.burnTime = value;
                    case 3 -> ForgeBlockEntity.this.maxBurnTime = value;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.explorers_of_ether.forge");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new ForgeMenu(i, inventory, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < 22; i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("forge.progress", progress);
        pTag.putInt("forge.max_progress", maxProgress);
        pTag.putInt("forge.burn_time", burnTime);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("forge.progress");
        maxProgress = pTag.getInt("forge.max_progress");
        burnTime = pTag.getInt("forge.burn_time");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        // Item Heating & Cooling
        for (int i = 0; i <= 20; i++) { // Explicitly loop through 0-20
            ItemStack itemStack = itemHandler.getStackInSlot(i);

            if (itemStack.isEmpty()) continue;

            // Check if the item is a HeatableItem
            if (itemStack.getItem() instanceof HotItem hotItem) {
                if (burnTime > 0) {
                    // Heating logic
                    if (itemStack.getDamageValue() > 0) {
                        // Reduce damage (increase heat)
                        itemStack.setDamageValue(itemStack.getDamageValue() - 1);
                    }
                } else {
                    // Cooling logic
                    if (itemStack.getDamageValue() < itemStack.getMaxDamage()) {
                        int newDamage = itemStack.getDamageValue() + 1;
                        itemStack.setDamageValue(newDamage);

                        // sound at halfway and full cooldown
                        if (newDamage == itemStack.getMaxDamage() / 2 || newDamage == itemStack.getMaxDamage()) {
                            level.playSound(
                                    null,
                                    blockPos,
                                    SoundEvents.FIRE_EXTINGUISH,
                                    SoundSource.PLAYERS,
                                    1.0f,
                                    1.0f
                            );
                        }

                        // when fully cooled, turn into cooled item
                        if (newDamage >= itemStack.getMaxDamage()) {
                            ItemStack cooledStack = hotItem.getCooledItem().copy();
                            cooledStack.setCount(itemStack.getCount());
                            itemHandler.setStackInSlot(i, cooledStack);
                        }
                    }
                }
            } else if (itemStack.getItem() instanceof HeatableItem heatableItem && burnTime > 0) {
                ItemStack heatedStack = heatableItem.getHeatedItem().copy();
                heatedStack.setCount(itemStack.getCount());
                itemHandler.setStackInSlot(i, heatedStack);
                heatedStack.setDamageValue(heatedStack.getMaxDamage());
            }
        }

        //Burning of the forge
        boolean hasFuel = isFuel(itemHandler.getStackInSlot(FUEL_SLOT));

        if (burnTime <= 0 && hasFuel) {
            burnTime = maxBurnTime;
            itemHandler.extractItem(FUEL_SLOT, 1, false);
        }

        if (burnTime > 0) {
            burnTime--;
        }

        setChanged(level, blockPos, blockState);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}