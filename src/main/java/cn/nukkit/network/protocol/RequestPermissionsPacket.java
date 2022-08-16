package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class RequestPermissionsPacket extends DataPacket {

    public long uniqueEntityId;
    public int permissions;
    public int customPermissions;

    @Override
    public byte pid() {
        return ProtocolInfo.REQUEST_PERMISSIONS_PACKET;
    }

    @Override
    public void decode() {
        this.uniqueEntityId = this.getLLong();
        this.permissions = this.getVarInt();
        this.customPermissions = this.getLShort();
    }

    @Override
    public void encode() {
        this.reset();
        this.putLLong(this.uniqueEntityId);
        this.putVarInt((byte) this.permissions);
        this.putLShort(this.customPermissions);
    }
}