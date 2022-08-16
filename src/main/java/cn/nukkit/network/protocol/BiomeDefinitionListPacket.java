package cn.nukkit.network.protocol;

import cn.nukkit.utils.BedrockResourceUtil;

public class BiomeDefinitionListPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.BIOME_DEFINITION_LIST_PACKET;

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
        this.put(BedrockResourceUtil.biomeDefinitionTag(this.protocolVersion));
    }
}