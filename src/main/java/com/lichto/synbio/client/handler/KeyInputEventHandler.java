package com.lichto.synbio.client.handler;

import com.lichto.synbio.client.settings.KeyBindings;
import com.lichto.synbio.reference.Key;
import com.lichto.synbio.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

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
        else if(KeyBindings.release.isPressed())
        {
            return Key.RELEASE;
        }
        else return Key.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        LogHelper.info(getPressedKeyBinding());
    }
}
