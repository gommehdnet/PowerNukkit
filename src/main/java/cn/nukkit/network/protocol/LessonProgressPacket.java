package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class LessonProgressPacket extends DataPacket {

    public byte action;
    public int score;
    public String identifier;

    @Override
    public byte pid() {
        return ProtocolInfo.LESSON_PROGRESS_PACKET;
    }

    @Override
    public void decode() {
        this.action = (byte) this.getByte();
        this.score = this.getVarInt();
        this.identifier = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte(this.action);
        this.putVarInt(this.score);
        this.putString(this.identifier);
    }
}