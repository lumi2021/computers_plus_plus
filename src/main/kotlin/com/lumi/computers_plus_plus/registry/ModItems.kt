package com.lumi.computers_plus_plus.registry

import com.lumi.computers_plus_plus.ComputersPlusPlus.Companion.MOD_ID
import net.minecraft.references.Blocks
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object ModItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(MOD_ID)

    val SILICON = ITEMS.register("silicon", Supplier { Item(Item.Properties()) })
    
    val LITOGRAPHY_MACHINE = ITEMS.register("litography_machine",
        Supplier { BlockItem(ModBlocks.LITOGRAPHY_MACHINE.block.get(), Item.Properties()) })
    
    val MOTHERBOARD_MK1 = ITEMS.register("motherboard_mk1", Supplier { Item(Item.Properties()) })

    fun register(movEventBus: IEventBus) {
        ITEMS.register(movEventBus)
    }
}
