package com.lumi.computers_plus_plus.blocks.entities

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

// FIXME
class LitographyMachineEntity(pos: BlockPos, blockState: BlockState)
    : BlockEntity(BlockEntityType.FURNACE, pos, blockState) {

    override fun clearRemoved() {


        
    }
    
}
