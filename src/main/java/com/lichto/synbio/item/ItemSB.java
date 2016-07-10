package com.lichto.synbio.item;

import com.lichto.synbio.creativetab.CreativeTab;
import com.lichto.synbio.reference.Reference;
import com.lichto.synbio.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Noah Lichtenstein on 6/19/2016.
 */
public class ItemSB extends Item
{
    private String registerName;

    public ItemSB()
    {
        super();
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTab.MT_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public void setRegisterName(String registerName)
    {
        this.registerName = registerName;
    }

    public String getRegisterName()
    {
        return this.registerName;
    }
}
