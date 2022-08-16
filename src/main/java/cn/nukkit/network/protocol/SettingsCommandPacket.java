package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class SettingsCommandPacket extends DataPacket {

    public String commandLine;
    public boolean suppressOutput;

    @Override
    public byte pid() {
        return ProtocolInfo.SETTINGS_COMMAND_PACKET;
    }

    @Override
    public void decode() {
        this.commandLine = this.getString();
        this.suppressOutput = this.getBoolean();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.commandLine);
        this.putBoolean(this.suppressOutput);
    }
}