package com.lumi.computers_plus_plus.registry


import com.lumi.computers_plus_plus.ComputersPlusPlus.Companion.MOD_ID
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object CreativeTabs {
    val CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID)

    val MainTab = CREATIVE_MODE_TABS.register("tab_main", Supplier { CreativeModeTab.builder()
        .title(Component.translatable("tab.computers_plus_plus.main"))
        .icon { ModBlocks.SILICON_BLOCK.item.get().defaultInstance}
        .displayItems { args, output ->
            // All mod items must be listed here!
            output.accept { ModItems.SILICON.get() }
            output.accept { ModBlocks.SILICON_BLOCK.item.get() }
        }
        .build()
    })
    
    fun register(movEventBus: IEventBus) {
        CREATIVE_MODE_TABS.register(movEventBus)
    }
}
