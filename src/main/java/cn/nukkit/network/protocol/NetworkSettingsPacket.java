package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.CompressionAlgorithm;

/**
 * @author Kaooot
 * @version 1.0
 */
public class NetworkSettingsPacket extends DataPacket {

    public short compressionThreshold;
    public CompressionAlgorithm compressionAlgorithm;

    @Override
    public byte pid() {
        return ProtocolInfo.NETWORK_SETTINGS_PACKET;
    }

    @Override
    public void decode() {
        this.compressionThreshold = (short) this.getLShort();

        if (this.protocolVersion >= Protocol.V1_19_30.version()) {
            this.compressionAlgorithm = CompressionAlgorithm.values()[(short) this.getLShort()];
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putLShort(this.compressionThreshold);

        if (this.protocolVersion >= Protocol.V1_19_30.version()) {
            this.putLShort(this.compressionAlgorithm.ordinal());
        }
    }
}