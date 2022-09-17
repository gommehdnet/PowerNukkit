package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.CompressionAlgorithm;

/**
 * @author Kaooot
 * @version 1.0
 */
public class NetworkSettingsPacket extends DataPacket {

    public short compressionThreshold;
    public CompressionAlgorithm compressionAlgorithm;
    public boolean clientThrottleEnabled;
    public byte clientThrottleThreshold;
    public float clientThrottleScalar;

    @Override
    public byte pid() {
        return ProtocolInfo.NETWORK_SETTINGS_PACKET;
    }

    @Override
    public void decode() {
        this.compressionThreshold = (short) this.getLShort();

        if (this.protocolVersion >= Protocol.V1_19_30.version()) {
            this.compressionAlgorithm = CompressionAlgorithm.values()[(short) this.getLShort()];
            this.clientThrottleEnabled = this.getBoolean();
            this.clientThrottleThreshold = (byte) this.getByte();
            this.clientThrottleScalar = this.getLFloat();
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putLShort(this.compressionThreshold);

        if (this.protocolVersion >= Protocol.V1_19_30.version()) {
            this.putLShort(this.compressionAlgorithm.ordinal());
            this.putBoolean(this.clientThrottleEnabled);
            this.putByte(this.clientThrottleThreshold);
            this.putLFloat(this.clientThrottleScalar);
        }
    }
}