package cn.nukkit.network.protocol;

import cn.nukkit.math.Vector3f;

/**
 * @author Kaooot
 * @version 1.0
 */
public class MotionPredictionHintsPacket extends DataPacket {

    public long entityRuntimeId;
    public Vector3f motion;
    public boolean onGround;

    @Override
    public byte pid() {
        return ProtocolInfo.MOTION_PREDICTION_HINTS_PACKET;
    }

    @Override
    public void decode() {
        this.entityRuntimeId = this.getUnsignedVarLong();
        this.motion = this.getVector3f();
        this.onGround = this.getBoolean();
    }

    @Override
    public void encode() {
        this.putUnsignedVarInt(this.entityRuntimeId);
        this.putVector3f(this.motion);
        this.putBoolean(this.onGround);
    }
}