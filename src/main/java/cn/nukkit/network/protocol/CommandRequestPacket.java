package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.CommandOriginData;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class CommandRequestPacket extends DataPacket {

    public String command;
    public CommandOriginData data;
    public boolean interval;

    @Override
    public byte pid() {
        return ProtocolInfo.COMMAND_REQUEST_PACKET;
    }

    @Override
    public void decode() {
        this.command = this.getString();
        this.data = this.getCommandOrigin();
        this.interval = this.getBoolean();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.command);
        this.putCommandOrigin(this.data);
        this.putBoolean(this.interval);
    }
}