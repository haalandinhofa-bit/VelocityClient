package com.velocityclient.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class ArmorStatusRenderer {
    public void render(int x, int y) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.thePlayer == null) return;
        int offset = 0;
        for (ItemStack stack : mc.thePlayer.inventory.armorInventory) {
            if (stack != null) mc.getRenderItem().renderItemAndEffectIntoGUI(stack, x + offset, y);
            offset += 18;
        }
    }
}
