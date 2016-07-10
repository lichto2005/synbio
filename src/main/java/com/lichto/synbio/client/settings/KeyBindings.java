package com.lichto.synbio.client.settings;

import com.lichto.synbio.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by Noah Lichtenstein on 7/3/2016.
 */
public class KeyBindings
{
    public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_C, Names.Keys.CATEGORY);
    public static KeyBinding itemInfo = new KeyBinding(Names.Keys.ITEMINFO, Keyboard.KEY_R, Names.Keys.CATEGORY);
}
