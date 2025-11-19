package com.lumi.computers_plus_plus.datagen

import com.lumi.computers_plus_plus.registry.ModBlocks
import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

class LootTables : BlockLootSubProvider {
    
    constructor(registries: HolderLookup.Provider)
            : super(
        setOf<Item>(),
        FeatureFlags.REGISTRY.allFlags(),
        registries) {}

    override fun getKnownBlocks(): Iterable<Block?> {
        return ModBlocks.BLOCKS.entries.map { it.get() }
    }
    
    override fun generate() {
        dropSelf(ModBlocks.SILICON_BLOCK.block.get())
        
        add(ModBlocks.SILICON_BLOCK.block.get())
            {block -> createSingleItemTable(ModBlocks.SILICON_BLOCK.item.get()) }
    }


}
