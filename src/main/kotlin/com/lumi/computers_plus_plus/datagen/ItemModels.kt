package com.lumi.computers_plus_plus.datagen

import com.lumi.computers_plus_plus.ComputersPlusPlus
import com.lumi.computers_plus_plus.registry.ModBlocks
import com.lumi.computers_plus_plus.registry.ModItems
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredItem

class ItemModels : ItemModelProvider {
    
    constructor(out: PackOutput, ex: ExistingFileHelper)
        : super(out, ComputersPlusPlus.MOD_ID, ex)
    {}

    override fun registerModels() {
        
        basicItem(ModItems.SILICON)
        simpleBlockItem(ModBlocks.SILICON_BLOCK)
        
    }
    
    
    fun basicItem(deferredItem: DeferredItem<*>) {
        basicItem(deferredItem.get());
    }
    fun simpleBlockItem(basicBlock: ModBlocks.BasicBlock<*>) {
        simpleBlockItem(basicBlock.block.get());
    }
}
