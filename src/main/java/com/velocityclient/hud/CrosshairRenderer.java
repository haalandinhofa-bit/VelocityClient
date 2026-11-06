package com.velocityclient.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class CrosshairRenderer {
    public void render(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.CROSSHAIRS) return;
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        int x=sr.getScaledWidth()/2, y=sr.getScaledHeight()/2;
        // Mantém o crosshair vanilla; esta classe é a base para estilos futuros.
    }
}
