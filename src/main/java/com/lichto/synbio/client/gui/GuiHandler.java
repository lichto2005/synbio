package com.lichto.synbio.client.gui;

import com.lichto.synbio.Synbio;
import com.lichto.synbio.client.container.ContainerFridge;
import com.lichto.synbio.reference.GuiID;
import com.lichto.synbio.tileentity.TileEntityFridge;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Noah Lichtenstein on 8/11/2016.
 */
public class GuiHandler implements IGuiHandler
{

    public GuiHandler()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(Synbio.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch(ID)
        {
            default:
                return null;
            case GuiID.FRIDGE_GUI_ID:
                if(entity != null && entity instanceof TileEntityFridge)
                {
                    return new ContainerFridge(player.inventory, (TileEntityFridge) entity);
                }
                else return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch(ID)
        {
            default:
                return null;
            case GuiID.FRIDGE_GUI_ID:
                if(entity != null && entity instanceof TileEntityFridge)
                {
                    return new GuiFridge(player.inventory, (TileEntityFridge) entity);
                }
                else return null;
        }
    }
}
