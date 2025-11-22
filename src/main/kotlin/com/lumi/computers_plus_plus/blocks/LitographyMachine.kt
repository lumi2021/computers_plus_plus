package com.lumi.computers_plus_plus.blocks

import com.lumi.computers_plus_plus.blocks.entities.LitographyMachineEntity
import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.AbstractFurnaceBlock
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.FurnaceBlock
import net.minecraft.world.level.block.HorizontalDirectionalBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.DirectionProperty

class LitographyMachine(props: Properties) : BaseEntityBlock(props) {
    
    var FACING: DirectionProperty = HorizontalDirectionalBlock.FACING
    val CODEC: MapCodec<LitographyMachine> = RecordCodecBuilder.mapCodec { instance ->
        instance.group(
            Properties.CODEC.fieldOf("properties")
                .forGetter { it.properties }
        ).apply(instance, ::LitographyMachine)
    }


    init {
        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH))
    }

    override fun codec(): MapCodec<out BaseEntityBlock?> = CODEC
    

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState? = 
        this.defaultBlockState().setValue(FACING, context.horizontalDirection.opposite)
    
    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block?, BlockState?>) {
        builder.add(FACING);
    }

    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity? {
        return LitographyMachineEntity(pos, state)
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