package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class PhotoInfoRequestPacket extends DataPacket {

    public long photoId;

    @Override
    public byte pid() {
        return ProtocolInfo.PHOTO_INFO_REQUEST_PACKET;
    }

    @Override
    public void decode() {
        this.photoId = this.getVarLong();
    }

    @Override
    public void encode() {
        this.reset();
        this.putVarLong(this.photoId);
    }
}