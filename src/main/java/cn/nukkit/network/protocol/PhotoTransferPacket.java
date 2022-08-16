package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.PhotoType;

/**
 * @author Kaooot
 * @version 1.0
 */
public class PhotoTransferPacket extends DataPacket {

    public String imageName;
    public String imageData;
    public String bookId;
    public PhotoType photoType;
    public PhotoType sourceType;
    public long ownerId;
    public String newPhotoName;

    @Override
    public byte pid() {
        return ProtocolInfo.PHOTO_TRANSFER_PACKET;
    }

    @Override
    public void decode() {
        this.imageName = this.getString();
        this.imageData = this.getString();
        this.bookId = this.getString();
        this.photoType = PhotoType.values()[this.getByte()];
        this.sourceType = PhotoType.values()[this.getByte()];
        this.ownerId = this.getLLong();
        this.newPhotoName = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.imageName);
        this.putString(this.imageData);
        this.putString(this.bookId);
        this.putByte((byte) this.photoType.ordinal());
        this.putByte((byte) this.sourceType.ordinal());
        this.putLLong(this.ownerId);
        this.putString(this.newPhotoName);
    }
}