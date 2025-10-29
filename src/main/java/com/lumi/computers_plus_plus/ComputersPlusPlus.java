package com.lumi.computers_plus_plus;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ComputersPlusPlus.MOD_ID)
public class ComputersPlusPlus {
    public static final String MOD_ID = "computers_plus_plus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);


    public ComputersPlusPlus(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        
        // Register defferred registers
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        // Register ourselves for listening to events
        NeoForge.EVENT_BUS.register(this);


        // Register mod's configuration specifications
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    
    
    public void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO from client");
    }
    

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server");
    }
}
