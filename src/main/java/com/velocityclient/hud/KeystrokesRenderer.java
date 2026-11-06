package com.velocityclient.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class KeystrokesRenderer {
    private final Minecraft mc = Minecraft.getMinecraft();
    public void render(int x, int y) {
        drawKey("W", mc.gameSettings.keyBindForward, x + 22, y);
        drawKey("A", mc.gameSettings.keyBindLeft, x, y + 22);
        drawKey("S", mc.gameSettings.keyBindBack, x + 22, y + 22);
        drawKey("D", mc.gameSettings.keyBindRight, x + 44, y + 22);
    }
    private void drawKey(String label, KeyBinding key, int x, int y) {
        int bg = key.isKeyDown() ? 0xAA55CCFF : 0xAA222222;
        net.minecraft.client.gui.Gui.drawRect(x, y, x + 20, y + 20, bg);
        mc.fontRendererObj.drawStringWithShadow(label, x + 7, y + 6, 0xFFFFFF);
    }
}
