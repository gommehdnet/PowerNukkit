package cn.nukkit.network.protocol;

public class AvailableEntityIdentifiersPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.AVAILABLE_ENTITY_IDENTIFIERS_PACKET;

    public byte[] data;

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
        this.put(this.data);
    }
}