package com.lichto.synbio.client.handler;

import com.lichto.synbio.client.settings.KeyBindings;
import com.lichto.synbio.item.ItemSB;
import com.lichto.synbio.reference.Key;
import com.lichto.synbio.utility.LogHelper;
import com.lichto.synbio.utility.NBTHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Noah Lichtenstein on 7/3/2016.
 */
public class KeyInputEventHandler
{
    private static Key getPressedKeyBinding()
    {
        if(KeyBindings.charge.isPressed())
        {
            return Key.CHARGE;
            // comment
        }
        else if(KeyBindings.itemInfo.isPressed())
        {
            return Key.ITEMINFO;
        }
        else return Key.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        Key keyPressed = getPressedKeyBinding();
        switch(keyPressed)
        {
            case ITEMINFO:
                EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                ItemStack itemInHand = player.getHeldItem();
                if(itemInHand != null && itemInHand.getItem() instanceof ItemSB)
                {
                    LogHelper.info("Item Damage: " + itemInHand.getItemDamage());
                    for(String key : NBTHelper.NBTKeys)
                    {
                        LogHelper.info(key + ": " + NBTHelper.getKeyValue(itemInHand, key));
                    }
                    player.addChatMessage(new ChatComponentText("Item Damage: " + itemInHand.getItemDamage()));
                }
                break;

            default:
                LogHelper.info(keyPressed);
                break;
        }

    }
}
