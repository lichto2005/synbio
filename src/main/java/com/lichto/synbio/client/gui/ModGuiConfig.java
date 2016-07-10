package com.lichto.synbio.client.gui;

import com.lichto.synbio.handler.ConfigurationHandler;
import com.lichto.synbio.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Init the configuration GUI
 *
 * Created by Noah Lichtenstein on 6/19/2016.
 */
public class ModGuiConfig extends GuiConfig
{
    /**
     * Constructor used to start the config GUI screen
     * @param guiScreen GuiScreen to display info to
     */
    public ModGuiConfig(GuiScreen guiScreen)
    {
        // takes the parent screen given as parameter
        // takes a list of elements in a category (in this case we make a new list and grab it directly
        // takes in MOD_ID and then the path of the config file we are loading (which we have to get indirectly since we dont actually know what it is
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
