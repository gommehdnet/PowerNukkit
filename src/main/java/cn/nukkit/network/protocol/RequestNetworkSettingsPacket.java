package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class RequestNetworkSettingsPacket extends DataPacket {

    public int clientProtocol;

    @Override
    public byte pid() {
        return ProtocolInfo.REQUEST_NETWORK_SETTINGS_PACKET;
    }

    @Override
    public void decode() {
        this.clientProtocol = this.getInt();
    }

    @Override
    public void encode() {
        this.reset();
        this.putInt(this.clientProtocol);
    }
}