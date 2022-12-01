package cn.nukkit.network.protocol;

import cn.nukkit.math.Vector3f;

/**
 * @author Kaooot
 * @version 1.0
 */
public class UpdateClientInputLocksPacket extends DataPacket {

    public int lockComponentData;
    public Vector3f serverPosition;

    @Override
    public byte pid() {
        return ProtocolInfo.UPDATE_CLIENT_INPUT_LOCKS_PACKET;
    }

    @Override
    public void decode() {
        this.lockComponentData = (int) this.getUnsignedVarInt();
        this.serverPosition = this.getVector3f();
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarInt(this.lockComponentData);
        this.putVector3f(this.serverPosition);
    }
}