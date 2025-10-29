package com.lumi.computers_plus_plus;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;


@Mod(value = ComputersPlusPlus.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = ComputersPlusPlus.MOD_ID, value = Dist.CLIENT)
public class ComputersPlusPlusClient {
    public ComputersPlusPlusClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        ComputersPlusPlus.LOGGER.info("HELLO FROM CLIENT SETUP");
        ComputersPlusPlus.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
