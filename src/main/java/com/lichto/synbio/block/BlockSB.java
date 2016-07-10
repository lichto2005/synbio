package com.lichto.synbio.block;

import com.lichto.synbio.creativetab.CreativeTab;
import com.lichto.synbio.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Noah Lichtenstein on 6/20/2016.
 */
public class BlockSB extends Block
{
    public BlockSB(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTab.MT_TAB);
    }

    public BlockSB()
    {
        super(Material.grass);
        this.setCreativeTab(CreativeTab.MT_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID_LOWERCASE + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
