package com.lichto.synbio.proxy;

import com.lichto.synbio.client.settings.KeyBindings;
import cpw.mods.fml.client.registry.ClientRegistry;

/**
 * Created by Noah Lichtenstein on 6/5/2016.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(KeyBindings.charge);
        ClientRegistry.registerKeyBinding(KeyBindings.release);
    }
}
