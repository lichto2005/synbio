package com.lichto.synbio.client.gui;

import com.lichto.synbio.client.container.ContainerFridge;
import com.lichto.synbio.reference.Reference;
import com.lichto.synbio.tileentity.TileEntityFridge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Noah Lichtenstein on 8/11/2016.
 */
public class GuiFridge extends GuiContainer
{
    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID_LOWERCASE, Reference.GUI_FRIDGE_LOCATION);

    public GuiFridge(InventoryPlayer inventoryPlayer, TileEntityFridge entity)
    {
        super(new ContainerFridge(inventoryPlayer, entity));
        xSize = 176;
        ySize = 165;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float i, int j, int k)
    {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
