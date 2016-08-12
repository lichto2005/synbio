package com.lichto.synbio.init;

import com.lichto.synbio.block.BlockContainerSB;
import com.lichto.synbio.block.BlockFlag;
import com.lichto.synbio.block.BlockFridge;
import com.lichto.synbio.block.BlockSB;
import com.lichto.synbio.reference.Names;
import com.lichto.synbio.reference.Reference;
import com.lichto.synbio.tileentity.TileEntityFridge;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Noah Lichtenstein on 6/20/2016.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockSB flag = new BlockFlag();
    public static final BlockContainerSB fridge = new BlockFridge();

    public static void init()
    {
        registerBlocks();
        registerTileEntities();
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
        GameRegistry.registerBlock(fridge, Names.Blocks.FRIDGE);
    }

    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityFridge.class, Names.TileEntities.FRIDGE);
    }

}
