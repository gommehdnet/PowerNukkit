package cn.nukkit.network.protocol;

import lombok.ToString;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@ToString
public class RequestChunkRadiusPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.REQUEST_CHUNK_RADIUS_PACKET;

    public int radius;
    public byte maxRadius;

    @Override
    public void decode() {
        this.radius = this.getVarInt();
        if (this.protocolVersion >= Protocol.V1_19_80.version()) {
            this.maxRadius = (byte) this.getByte();
        }
    }

    @Override
    public void encode() {

    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

}
