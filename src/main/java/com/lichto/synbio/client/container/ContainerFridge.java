package com.lichto.synbio.client.container;

import com.lichto.synbio.tileentity.TileEntityFridge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Noah Lichtenstein on 8/11/2016.
 */
public class ContainerFridge extends Container
{
    private TileEntityFridge fridge;

    public ContainerFridge(InventoryPlayer inventoryPlayer, TileEntityFridge entity)
    {
        this.fridge = entity;

        for(int i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, 9 + j + 9 * i, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                this.addSlotToContainer(new Slot(entity, j + i * 3, 62 + j * 18, 17 + i * 18));
            }
        }

    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i)
    {
        //slot the itemstack is being transferred FROM
        Slot slot = getSlot(i);

        //if there is something in the slot
        if(slot != null && slot.getHasStack())
        {

            //retrieve the stack
            ItemStack itemStack = slot.getStack();
            ItemStack resultStack = itemStack.copy();

            //slots 1-36 are the inventory, slots 37-45 are the grid
            //so, if transferring from the grid
            if(i >= 36)
            {
                //if no space is available in the inventory
                if(!mergeItemStack(itemStack, 0, 36, false))
                {
                    //do nothing
                    return null;
                }
            }
            //if transferring from inventory and no space in the grid
            else if(!mergeItemStack(itemStack, 36, 36 + fridge.getSizeInventory(), false))
            {
                //do nothing
                return null;
            }

            //if itemstack is empty
            if(itemStack.stackSize == 0)
            {
                //remove item from slot after transfer
                slot.putStack(null);
            }
            else
            {
                //else update the contents of the slot
                slot.onSlotChanged();
            }
            //mark dirty
            slot.onPickupFromSlot(entityPlayer, itemStack);
            //return the stack that was copied (WHY??)
            return resultStack;
        }
        return null;
    }



    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return fridge.isUseableByPlayer(player);
    }
}