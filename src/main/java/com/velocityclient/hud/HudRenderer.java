package com.velocityclient.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HudRenderer {
    private final Minecraft mc = Minecraft.getMinecraft();
    private final HudSettings settings = new HudSettings();
    private final KeystrokesRenderer keystrokes = new KeystrokesRenderer();
    private final ClickCounter leftClicks = new ClickCounter();
    private boolean lastAttack;

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text event) {
        if (mc.thePlayer == null) return;
        boolean attack = mc.gameSettings.keyBindAttack.isKeyDown();
        if (attack && !lastAttack) leftClicks.click();
        lastAttack = attack;

        ScaledResolution sr = new ScaledResolution(mc);
        if (settings.showFps) draw("FPS: " + Minecraft.getDebugFPS(), 6, 6, 0xFFFFFF);
        if (settings.showPing) draw("Ping: " + getPing() + " ms", 6, 18, 0xFFFFFF);
        if (settings.showCps) draw("CPS: " + leftClicks.getCps(), 6, 30, 0xFFFFFF);
        if (settings.showKeystrokes) keystrokes.render(6, sr.getScaledHeight() - 52);
        if (settings.showBrand) {
            String brand = "Velocity Client";
            draw(brand, sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(brand) - 6, 6, 0x55CCFF);
        }
    }

    private void draw(String text, int x, int y, int color) { mc.fontRendererObj.drawStringWithShadow(text, x, y, color); }

    private int getPing() {
        if (mc.getNetHandler() == null || mc.thePlayer == null) return 0;
        net.minecraft.client.network.NetworkPlayerInfo info = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
        return info == null ? 0 : info.getResponseTime();
    }
}