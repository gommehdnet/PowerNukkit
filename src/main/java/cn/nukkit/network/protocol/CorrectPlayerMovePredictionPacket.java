package cn.nukkit.network.protocol;

import cn.nukkit.math.Vector3f;

/**
 * @author Kaooot
 * @version 1.0
 */
public class CorrectPlayerMovePredictionPacket extends DataPacket {

    public Vector3f position;
    public Vector3f delta;
    public boolean onGround;
    public long tick;

    @Override
    public byte pid() {
        return ProtocolInfo.CORRECT_PLAYER_MOVE_PREDICTION_PACKET;
    }

    @Override
    public void decode() {
        this.position = this.getVector3f();
        this.delta = this.getVector3f();
        this.onGround = this.getBoolean();
        this.tick = this.getUnsignedVarLong();
    }

    @Override
    public void encode() {
        this.reset();
        this.putVector3f(this.position);
        this.putVector3f(this.delta);
        this.putBoolean(this.onGround);
        this.putUnsignedVarLong(this.tick);
    }
}