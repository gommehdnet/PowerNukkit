package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.PlayerPermission;

/**
 * @author Kaooot
 * @version 1.0
 */
public class RequestPermissionsPacket extends DataPacket {

    public long uniqueEntityId;
    public PlayerPermission permissions;
    public int customPermissions;

    @Override
    public byte pid() {
        return ProtocolInfo.REQUEST_PERMISSIONS_PACKET;
    }

    @Override
    public void decode() {
        this.uniqueEntityId = this.getLLong();
        this.permissions = PlayerPermission.values()[this.getByte()];
        this.customPermissions = this.getLShort();
    }

    @Override
    public void encode() {
        this.putLLong(this.uniqueEntityId);
        this.putByte((byte) this.permissions.ordinal());
        this.putLShort(this.customPermissions);
    }
}