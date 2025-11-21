package com.lumi.computers_plus_plus.screen

import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.MenuType
import net.minecraft.world.item.ItemStack

class LitographyMachine(menuType: MenuType<*>?, containerId: Int)
    : AbstractContainerMenu(menuType, containerId) {
    
    
    
    
    override fun quickMoveStack(player: Player, index: Int): ItemStack {
        TODO("Not yet implemented")
    }

    override fun stillValid(player: Player): Boolean {
        TODO("Not yet implemented")
    }

}