package com.lumi.computers_plus_plus.datagen

import com.lumi.computers_plus_plus.ComputersPlusPlus
import com.lumi.computers_plus_plus.blocks.LitographyMachine
import com.lumi.computers_plus_plus.registry.ModBlocks
import net.minecraft.core.Direction
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.HorizontalDirectionalBlock
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.client.model.generators.ConfiguredModel
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredBlock

class BlockStates : BlockStateProvider {

    constructor(out: PackOutput, ex: ExistingFileHelper)
        : super(out, ComputersPlusPlus.MOD_ID,ex)
    {
        
    }
    
    override fun registerStatesAndModels() {
        
        blockWithItem(ModBlocks.SILICON_BLOCK)
        
        getVariantBuilder(ModBlocks.LITOGRAPHY_MACHINE.block.get())
            .forAllStates { state ->
            val dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING)

            val rotY = when (dir) {
                Direction.SOUTH -> 0
                Direction.WEST  -> 90
                Direction.NORTH -> 180
                Direction.EAST  -> 270
                else -> 0
            }

            ConfiguredModel.builder()
                .modelFile(models().getExistingFile(modLoc("block/litography_machine")))
                .rotationY(rotY)
                .build()
        }
    }
    
    
    private fun blockWithItem(basicBlock: ModBlocks.BasicBlock<*>) {
        simpleBlockWithItem(basicBlock.block.get(), cubeAll(basicBlock.block.get()));
    }
}
