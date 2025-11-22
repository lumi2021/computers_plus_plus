package com.lumi.computers_plus_plus.datagen

import com.lumi.computers_plus_plus.ComputersPlusPlus
import com.lumi.computers_plus_plus.registry.ModBlocks
import com.lumi.computers_plus_plus.registry.ModItems
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem

class ItemModels : ItemModelProvider {
    
    constructor(out: PackOutput, ex: ExistingFileHelper)
        : super(out, ComputersPlusPlus.MOD_ID, ex)
    {}

    override fun registerModels() {
        
        
        basicItem(ModItems.SILICON)
        basicBlock(ModBlocks.SILICON_BLOCK)
        
        basicItem(ModItems.MOTHERBOARD_MK1)

        modelItem(ModItems.LITOGRAPHY_MACHINE, modLoc("block/litography_machine"))
        
    }
    
    
    fun basicItem(deferredItem: DeferredItem<*>) {
        basicItem(deferredItem.get());
    
    }fun modelItem(deferredItem: DeferredItem<*>, res: ResourceLocation) {
        withExistingParent(deferredItem.get().toString(), res);
    }
    fun basicBlock(basicBlock: ModBlocks.BasicBlock<*>) {
        simpleBlockItem(basicBlock.block.get());
    }
    
}
