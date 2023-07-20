package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class AgentAnimationPacket extends DataPacket {

    public byte animation;
    public long runtimeEntityId;

    @Override
    public byte pid() {
        return ProtocolInfo.AGENT_ANIMATION_PACKET;
    }

    @Override
    public void decode() {
        this.animation = (byte) this.getByte();
        this.runtimeEntityId = this.getEntityRuntimeId();
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte(this.animation);
        this.putEntityRuntimeId(this.runtimeEntityId);
    }
}