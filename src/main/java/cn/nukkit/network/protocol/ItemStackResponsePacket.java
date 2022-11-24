package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.ItemStackResponse;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

public class ItemStackResponsePacket extends DataPacket {

    public List<ItemStackResponse> responses = new ObjectArrayList<>();

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarInt(this.responses.size());

        for (ItemStackResponse response : this.responses) {
            this.putItemStackResponse(response);
        }
    }

    @Override
    public byte pid() {
        return ProtocolInfo.ITEM_STACK_RESPONSE_PACKET;
    }
}