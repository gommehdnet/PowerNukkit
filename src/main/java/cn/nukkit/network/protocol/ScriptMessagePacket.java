package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ScriptMessagePacket extends DataPacket {

    public String messageId;
    public String data;

    @Override
    public byte pid() {
        return ProtocolInfo.SCRIPT_MESSAGE_PACKET;
    }

    @Override
    public void decode() {
        this.messageId = this.getString();
        this.data = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.messageId);
        this.putString(this.data);
    }
}