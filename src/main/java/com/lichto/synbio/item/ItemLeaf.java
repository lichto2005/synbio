package com.lichto.synbio.item;

import com.lichto.synbio.block.BlockFlag;
import com.lichto.synbio.reference.Names;
import com.lichto.synbio.utility.LogHelper;
import com.lichto.synbio.utility.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Noah Lichtenstein on 6/19/2016.
 */
public class ItemLeaf extends ItemSB
{
    public ItemLeaf()
    {
        super();
        // dont know how this name affects anything
        this.setUnlocalizedName(Names.Items.LEAF);

        this.maxStackSize = 1;
        this.hasSubtypes = false;
        this.setMaxDamage(10);
    }



    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(x,y,z);
        String blockName = block.getLocalizedName();
        //LogHelper.info(String.format("Leaf used to hit %s at X:%d Y:%d Z:%d", blockName, x, y, z));

        if(block instanceof BlockFlag)
        {
            //LogHelper.info(String.format("side:%d X:%f Y:%f Z:%f", side, hitX, hitY, hitZ));
        }

        stack.damageItem(1, player);

        if(stack.getItemDamage() > 5)
        {
            NBTHelper.setString(stack, "teststring", "DAMAGED");
        }
        else NBTHelper.setString(stack, "teststring", "NOT DAMAGED");

        return false;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        return true;
    }

}
