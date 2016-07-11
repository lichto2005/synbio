package com.lichto.synbio.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Noah Lichtenstein on 7/10/2016.
 */
public class TestMessage implements IMessage
{
    private int number;

    public TestMessage() {}

    public TestMessage(int i)
    {
        this.number = i;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        number = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(number);
    }

    public int getNum()
    {
        return this.number;
    }

    public static class Handler implements IMessageHandler<TestMessage, IMessage>
    {
        @Override
        public IMessage onMessage(TestMessage message, MessageContext ctx)
        {
            ctx.getServerHandler().playerEntity.addChatMessage(new ChatComponentText("Received packed with val: " + message.getNum()));
            return null;
        }
    }
}
