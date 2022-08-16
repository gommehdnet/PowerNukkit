package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class AgentActionPacket extends DataPacket {

    public String requestId;
    public String body;

    @Override
    public byte pid() {
        return ProtocolInfo.AGENT_ACTION_PACKET;
    }

    @Override
    public void decode() {
        this.requestId = this.getString();
        this.body = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.requestId);
        this.putString(this.body);
    }
}