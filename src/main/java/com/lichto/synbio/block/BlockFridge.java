package com.lichto.synbio.block;

import com.lichto.synbio.Synbio;
import com.lichto.synbio.reference.GuiID;
import com.lichto.synbio.reference.Names;
import com.lichto.synbio.tileentity.TileEntityFridge;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by Noah Lichtenstein on 8/11/2016.
 */
public class BlockFridge extends BlockContainerSB
{
    private int numTextures = 3;
    private IIcon[] icons = new IIcon[numTextures];

    public BlockFridge()
    {
        super();
        this.setBlockName(Names.Blocks.FRIDGE);
        this.setBlockTextureName(Names.Blocks.FRIDGE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityFridge();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i = 0; i < this.numTextures; i++)
        {
            this.icons[i] = iconRegister.registerIcon(String.format("%s_%d", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), i + 1));
        }
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if(side == 0 || side == 1)
        {
            //top and bottom use tex 0
            return this.icons[0];
        }
        else if(side != meta)
        {
            //if not facing direction player is placing on use side tex 1
            return this.icons[1];
        }
        //if the final side must be the meta side, use that as front tex 2
        else return this.icons[2];
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        byte meta = 3;
        super.onBlockAdded(world, x, y, z);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        int rotation = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360F) + 0.5D) & 3;

        if(rotation == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if(rotation == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if(rotation == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if(rotation == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            FMLNetworkHandler.openGui(player, Synbio.instance, GuiID.FRIDGE_GUI_ID, world, x, y, z);
        }
        return true;
    }


}
