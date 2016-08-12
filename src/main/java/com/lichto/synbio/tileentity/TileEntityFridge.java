package com.lichto.synbio.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

/**
 * Created by Noah Lichtenstein on 8/11/2016.
 */
public class TileEntityFridge extends TileEntity implements IInventory
{
    private ItemStack[] inventory;
    private String name;

    public TileEntityFridge()
    {
        inventory = new ItemStack[9];
    }

    @Override
    public int getSizeInventory()
    {
        return this.inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return this.inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int count)
    {
        ItemStack itemStack = getStackInSlot(slot);
        if(itemStack != null)
        {
            if(itemStack.stackSize <= count)
            {
                setInventorySlotContents(slot, null);
            }
            else
            {
                itemStack = itemStack.splitStack(count);
            }
            markDirty();
        }
        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack itemStack = getStackInSlot(slot);
        setInventorySlotContents(slot, null);
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        this.inventory[slot] = itemStack;
        if(itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
        markDirty();
    }

    @Override
    public String getInventoryName()
    {
        return hasCustomInventoryName() ? this.name : "FRIDGE Inventory";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return this.name != null;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return entityPlayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
    }

    @Override
    public void openInventory()
    {

    }

    @Override
    public void closeInventory()
    {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        NBTTagList list = compound.getTagList("itemsfridge", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < list.tagCount(); i++)
        {
            NBTTagCompound item = (NBTTagCompound) list.getCompoundTagAt(i);
            int slot = item.getByte("slotfridge");
            if(slot >= 0 && slot < getSizeInventory())
            {
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        NBTTagList list = new NBTTagList();

        for(int i = 0; i < getSizeInventory(); i++)
        {
            ItemStack itemStack = getStackInSlot(i);
            if(itemStack != null)
            {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("slotfridge", (byte) i);
                itemStack.writeToNBT(item);
                list.appendTag(item);
            }
        }
        compound.setTag("itemsfridge", list);
    }
}
