package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class RefreshEntitlementsPacket extends DataPacket {

    @Override
    public byte pid() {
        return ProtocolInfo.REFRESH_ENTITLEMENTS_PACKET;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {

    }
}