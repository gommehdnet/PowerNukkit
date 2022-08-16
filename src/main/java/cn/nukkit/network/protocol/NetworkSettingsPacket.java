package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class NetworkSettingsPacket extends DataPacket {

    public short compressionThreshold;

    @Override
    public byte pid() {
        return ProtocolInfo.NETWORK_SETTINGS_PACKET;
    }

    @Override
    public void decode() {
        this.compressionThreshold = (short) this.getLShort();
    }

    @Override
    public void encode() {
        this.reset();
        this.putLShort(this.compressionThreshold);
    }
}