package cn.nukkit.network.protocol;

import cn.nukkit.utils.BedrockResourceUtil;

public class AvailableEntityIdentifiersPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.AVAILABLE_ENTITY_IDENTIFIERS_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.put(BedrockResourceUtil.entityIdentifiersTag(this.protocolVersion));
    }
}