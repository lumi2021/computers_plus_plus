package com.lumi.computers_plus_plus.blocks.entities

import com.lumi.computers_plus_plus.registry.ModBlocks
import net.minecraft.core.BlockPos
import net.minecraft.core.HolderLookup
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.Containers
import net.minecraft.world.SimpleContainer
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.items.ItemStackHandler

class LitographyMachineEntity(pos: BlockPos, blockState: BlockState)
    : BlockEntity(ModBlocks.LITOGRAPHY_MACHINE.entity.get(), pos, blockState) {

    val inventory: ItemStackHandler = object : ItemStackHandler(4) {
        override fun getStackLimit(slot: Int, stack: ItemStack): Int { return 4 }

        override fun onContentsChanged(slot: Int) {
            setChanged()
            if (!level!!.isClientSide()) {
                level!!.sendBlockUpdated(
                    blockPos,
                    getBlockState(),
                    getBlockState(),
                    3)
            }
        }
    }

    fun clearContents() {
        inventory.setStackInSlot(0, ItemStack.EMPTY)
        inventory.setStackInSlot(1, ItemStack.EMPTY)
        inventory.setStackInSlot(2, ItemStack.EMPTY)
        inventory.setStackInSlot(3, ItemStack.EMPTY)
    }
    
    fun dropContents() {
        val inv: SimpleContainer = SimpleContainer(inventory.slots)

        for (i in 0..<inventory.slots) {
            inv.setItem(i, inventory.getStackInSlot(i))
        }

        Containers.dropContents(level, worldPosition, inv)
    }

    override fun loadAdditional(tag: CompoundTag, registries: HolderLookup.Provider) {
        super.loadAdditional(tag, registries)
        tag.put("inventory", inventory.serializeNBT(registries))
    }

    override fun saveAdditional(tag: CompoundTag, registries: HolderLookup.Provider) {
        super.saveAdditional(tag, registries)
        inventory.deserializeNBT(registries, tag.getCompound("inventory"))
    }
    
}
