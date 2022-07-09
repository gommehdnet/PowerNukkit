package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class CreatePhotoPacket extends DataPacket{

    public long entityUniqueId;
    public String photoName;
    public String itemName;

    @Override
    public byte pid() {
        return ProtocolInfo.CREATE_PHOTO_PACKET;
    }

    @Override
    public void decode() {
        this.entityUniqueId = this.getLLong();
        this.photoName = this.getString();
        this.itemName = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putLLong(this.entityUniqueId);
        this.putString(this.photoName);
        this.putString(this.itemName);
    }
}