package com.lumi.computers_plus_plus.blocks

import com.lumi.computers_plus_plus.blocks.entities.LitographyMachineEntity
import com.mojang.serialization.MapCodec
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.HorizontalDirectionalBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.DirectionProperty

class LitographyMachine(props: Properties) : BaseEntityBlock(props) {

    
    val FACING: DirectionProperty = HorizontalDirectionalBlock.FACING
    val CODEC: MapCodec<LitographyMachine> = simpleCodec(::LitographyMachine)
    
    override fun codec(): MapCodec<out BaseEntityBlock?> { return CODEC }

    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity? {
        TODO("Not yet implemented")
    }

    override fun onRemove(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        newState: BlockState,
        movedByPiston: Boolean
    ) {
        if (state.block != newState.block) {
            val entity = level.getBlockEntity(pos)
            if (entity is LitographyMachineEntity) {
                level.updateNeighbourForOutputSignal(pos, this)
            }
        }
        
        super.onRemove(state, level, pos, newState, movedByPiston)
    }


}