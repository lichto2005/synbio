package com.lichto.synbio.init;

import com.lichto.synbio.item.ItemLeaf;
import com.lichto.synbio.item.ItemSB;
import com.lichto.synbio.reference.Names;
import com.lichto.synbio.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Noah Lichtenstein on 6/19/2016.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemSB leaf = new ItemLeaf();

    public static void init()
    {
        // this registery is how the item is referenced
        GameRegistry.registerItem(leaf, Names.Items.LEAF);
    }
}
