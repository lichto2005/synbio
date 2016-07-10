package com.lichto.synbio.utility;

import com.lichto.synbio.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;

import java.util.UUID;

/**
 * Created by Noah Lichtenstein on 7/3/2016.
 */
public class NBTHelper
{

    public static void clearStatefulNBTTags(ItemStack itemStack)
    {
        //TODO: do i need this method?
    }

    public static final String[] NBTKeys = {
            "teststring"
    };

    public static String getKeyValue(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            return itemStack.getTagCompound().getTag(keyName).toString();
        }
        else return "undef";
    }

    public static boolean hasKey(ItemStack itemStack, String keyName)
    {
        // returns true if itemstack has the given keyname (not its value)
        return itemStack != null && itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey(keyName);
    }

    public static void removeTag(ItemStack itemStack, String keyName)
    {
        if(itemStack != null && itemStack.stackTagCompound != null && keyName != null && !keyName.isEmpty())
        {
            itemStack.stackTagCompound.removeTag(keyName);
        }
    }

    //TODO: implement Universally Unique IDentifier
    public static boolean hasUUID(ItemStack itemStack)
    {
        return getLong(itemStack, Names.NBT.UUID_MOST_SIG) != null && getLong(itemStack, Names.NBT.UUID_LEAST_SIG) != null;
    }

    public static UUID getUUID(ItemStack itemStack)
    {
        if(hasUUID(itemStack))
        {
            return new UUID(getLong(itemStack, Names.NBT.UUID_MOST_SIG), getLong(itemStack, Names.NBT.UUID_LEAST_SIG));
        }

        return null;
    }

    public static void setUUID(ItemStack itemStack, UUID uuid)
    {
        if(itemStack != null)
        {
            initNBTTagCompound(itemStack);

            if(uuid == null)
            {
                uuid = UUID.randomUUID();
            }

            setLong(itemStack, Names.NBT.UUID_MOST_SIG, uuid.getMostSignificantBits());
            setLong(itemStack, Names.NBT.UUID_LEAST_SIG, uuid.getLeastSignificantBits());
        }
    }

    private static void initNBTTagCompound(ItemStack itemStack)
    {
        if(itemStack != null && itemStack.stackTagCompound == null)
        {
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public static String getString(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagString)
            {
                return itemStack.stackTagCompound.getString(keyName);
            }
        }

        return null;
    }

    public static void setString(ItemStack itemStack, String keyName, String keyValue)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setString(keyName, keyValue);
        }
    }

    public static Boolean getBoolean(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagByte)
            {
                return itemStack.stackTagCompound.getBoolean(keyName);
            }
        }

        return null;
    }

    public static void setBoolean(ItemStack itemStack, String keyName, boolean keyValue)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setBoolean(keyName, keyValue);
        }
    }

    public static Byte getByte(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagByte)
            {
                return itemStack.stackTagCompound.getByte(keyName);
            }
        }

        return null;
    }

    public static void setByte(ItemStack itemStack, String keyName, byte keyValue)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setByte(keyName, keyValue);
        }
    }

    public static Short getShort(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagShort)
            {
                return itemStack.stackTagCompound.getShort(keyName);
            }
        }

        return null;
    }

    public static void setShort(ItemStack itemStack, String keyName, short keyValue)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setShort(keyName, keyValue);
        }
    }

    public static Integer getInteger(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagInt)
            {
                return itemStack.stackTagCompound.getInteger(keyName);
            }
        }

        return null;
    }

    public static void setInteger(ItemStack itemStack, String keyName, int keyValue)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setInteger(keyName, keyValue);
        }
    }

    public static Long getLong(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagLong)
            {
                return itemStack.stackTagCompound.getLong(keyName);
            }
        }

        return null;
    }

    public static void setLong(ItemStack itemStack, String keyName, long keyValue)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setLong(keyName, keyValue);
        }
    }

    public static Float getFloat(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagFloat)
            {
                return itemStack.stackTagCompound.getFloat(keyName);
            }
        }

        return null;
    }

    public static void setFloat(ItemStack itemStack, String keyName, float keyValue)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setFloat(keyName, keyValue);
        }
    }

    public static Double getDouble(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagDouble)
            {
                return itemStack.stackTagCompound.getDouble(keyName);
            }
        }

        return null;
    }

    public static void setDouble(ItemStack itemStack, String keyName, double keyValue)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setDouble(keyName, keyValue);
        }
    }

    public static NBTTagList getTagList(ItemStack itemStack, String keyName, int nbtBaseType)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagList)
            {
                return itemStack.stackTagCompound.getTagList(keyName, nbtBaseType);
            }
        }

        return null;
    }

    public static void setTagList(ItemStack itemStack, String keyName, NBTTagList nbtTagList)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setTag(keyName, nbtTagList);
        }
    }

    public static NBTTagCompound getTagCompound(ItemStack itemStack, String keyName)
    {
        if(hasKey(itemStack, keyName))
        {
            if(itemStack.getTagCompound().getTag(keyName) instanceof NBTTagCompound)
            {
                return itemStack.stackTagCompound.getCompoundTag(keyName);
            }
        }

        return null;
    }

    public static void setTagCompound(ItemStack itemStack, String keyName, NBTTagCompound nbtTagCompound)
    {
        if(itemStack != null && keyName != null && !keyName.isEmpty())
        {
            initNBTTagCompound(itemStack);
            itemStack.stackTagCompound.setTag(keyName, nbtTagCompound);
        }
    }

}
