package com.lumi.computers_plus_plus.datagen

import com.lumi.computers_plus_plus.ComputersPlusPlus
import com.lumi.computers_plus_plus.registry.ModBlocks
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredBlock

class BlockStates : BlockStateProvider {

    constructor(out: PackOutput, ex: ExistingFileHelper)
        : super(out, ComputersPlusPlus.MOD_ID,ex)
    {
        
    }
    
    override fun registerStatesAndModels() {
        blockWithItem(ModBlocks.SILICON_BLOCK);
    }
    
    
    private fun blockWithItem(basicBlock: ModBlocks.BasicBlock<*>) {
        simpleBlockWithItem(basicBlock.block.get(), cubeAll(basicBlock.block.get()));
        
    }
}