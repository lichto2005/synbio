package com.lichto.synbio.init;

import com.lichto.synbio.block.BlockFlag;
import com.lichto.synbio.block.BlockSB;
import com.lichto.synbio.reference.Names;
import com.lichto.synbio.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Noah Lichtenstein on 6/20/2016.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockSB flag = new BlockFlag();

    public static void init()
    {
        GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
    }
}
