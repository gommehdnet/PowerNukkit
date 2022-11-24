package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.ItemStackRequest;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.ToString;

import java.util.List;

@ToString
public class ItemStackRequestPacket extends DataPacket {

    public List<ItemStackRequest> requests = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.ITEM_STACK_REQUEST_PACKET;
    }

    @Override
    public void decode() {
        final int requestsLength = (int) this.getUnsignedVarInt();

        for (int i = 0; i < requestsLength; i++) {
            this.requests.add(this.getItemStackRequest(this.protocolVersion));
        }
    }

    @Override
    public void encode() {

    }
}