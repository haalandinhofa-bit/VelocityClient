package com.velocityclient;

import com.velocityclient.hud.HudRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = VelocityClient.MODID, name = VelocityClient.NAME, version = VelocityClient.VERSION, clientSideOnly = true)
public class VelocityClient {
    public static final String MODID = "velocityclient";
    public static final String NAME = "Velocity Client";
    public static final String VERSION = "0.1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new HudRenderer());
    }
}
