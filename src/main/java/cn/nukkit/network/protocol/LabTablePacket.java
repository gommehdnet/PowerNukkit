package cn.nukkit.network.protocol;

import cn.nukkit.math.Vector3f;
import cn.nukkit.network.protocol.types.LabTableActionType;

/**
 * @author Kaooot
 * @version 1.0
 */
public class LabTablePacket extends DataPacket {

    public LabTableActionType actionType;
    public Vector3f position;
    public byte reactionType;

    @Override
    public byte pid() {
        return ProtocolInfo.LAB_TABLE_PACKET;
    }

    @Override
    public void decode() {
        this.actionType = LabTableActionType.values()[this.getByte()];
        this.position = this.getVector3f();
        this.reactionType = (byte) this.getByte();
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.actionType.ordinal());
        this.putVector3f(this.position);
        this.putByte(this.reactionType);
    }
}