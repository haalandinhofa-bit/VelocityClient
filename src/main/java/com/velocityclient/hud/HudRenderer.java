package com.velocityclient.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HudRenderer {
    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text event) {
        if (mc.thePlayer == null) return;
        ScaledResolution sr = new ScaledResolution(mc);
        draw("FPS: " + Minecraft.getDebugFPS(), 6, 6, 0xFFFFFF);
        draw("Ping: " + getPing() + " ms", 6, 18, 0xFFFFFF);
        String brand = "Velocity Client";
        draw(brand, sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(brand) - 6, 6, 0x55CCFF);
    }

    private void draw(String text, int x, int y, int color) {
        mc.fontRendererObj.drawStringWithShadow(text, x, y, color);
    }

    private int getPing() {
        if (mc.getNetHandler() == null || mc.thePlayer == null) return 0;
        NetworkPlayerInfo info = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
        return info == null ? 0 : info.getResponseTime();
    }
}
