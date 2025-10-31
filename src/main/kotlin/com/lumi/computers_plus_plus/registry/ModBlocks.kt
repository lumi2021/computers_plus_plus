package com.lumi.computers_plus_plus.registry

import com.lumi.computers_plus_plus.ComputersPlusPlus.Companion.MOD_ID
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object ModBlocks {
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(MOD_ID)

    
    val SILICON_BLOCK = registerBasicBlock("silicon_block", {
        Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLACK)
            .strength(4f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.AMETHYST)) })
    
    
    fun <T1: Block> registerBasicBlock(name: String, block: Supplier<T1>): BasicBlock<T1> {
        val block = BLOCKS.register(name, block)
        val item = registerBlockItem(name, block)
        return BasicBlock(block, item);
    }
    
    fun <T: Block> registerBlockItem(name: String, block: DeferredBlock<T>): DeferredItem<BlockItem> {
        return ModItems.ITEMS.register(name, Supplier { BlockItem(block.get(), Item.Properties()) })
    }
    
    fun register(movEventBus: IEventBus) {
        BLOCKS.register(movEventBus)
    }
    
    data class BasicBlock<T: Block>(val block: DeferredBlock<T>, val item: DeferredItem<BlockItem>)
}
