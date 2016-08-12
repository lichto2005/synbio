package com.lichto.synbio.creativetab;

import com.lichto.synbio.init.ModItems;
import com.lichto.synbio.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Noah Lichtenstein on 6/19/2016.
 */
public class CreativeTab
{
    public static final CreativeTabs SB_TAB = new CreativeTabs(Reference.MOD_ID_LOWERCASE)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.leaf;
        }

        public String getTabLabel()
        {
            return Reference.MOD_ID;
        }

        public String getTranslatedTabLabel()
        {
            return getTabLabel();
        }
    };

}
