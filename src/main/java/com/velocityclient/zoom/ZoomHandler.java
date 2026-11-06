package com.velocityclient.zoom;

import net.minecraft.client.Minecraft;

public class ZoomHandler {
    private float previousFov = -1F;
    public void enable() { Minecraft mc=Minecraft.getMinecraft(); if(previousFov<0F){ previousFov=mc.gameSettings.fovSetting; mc.gameSettings.fovSetting=30F; } }
    public void disable() { Minecraft mc=Minecraft.getMinecraft(); if(previousFov>=0F){ mc.gameSettings.fovSetting=previousFov; previousFov=-1F; } }
}
