package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class CodeBuilderSourcePacket extends DataPacket {

    public String value;

    @Override
    public byte pid() {
        return ProtocolInfo.CODE_BUILDER_SOURCE_PACKET;
    }

    @Override
    public void decode() {
        this.value = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.value);
    }
}