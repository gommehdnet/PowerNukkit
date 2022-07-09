package cn.nukkit.network.protocol;

import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.types.StructureTemplateResponseType;

/**
 * @author Kaooot
 * @version 1.0
 */
public class StructureTemplateDataExportResponsePacket extends DataPacket {

    public String name;
    public boolean save;
    public CompoundTag tag;
    public StructureTemplateResponseType responseType;

    @Override
    public byte pid() {
        return ProtocolInfo.STRUCTURE_TEMPLATE_DATA_EXPORT_RESPONSE_PACKET;
    }

    @Override
    public void decode() {
        this.name = this.getString();
        this.save = this.getBoolean();
        this.tag = this.getTag();
        this.responseType = StructureTemplateResponseType.values()[this.getByte()];
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.name);
        this.putBoolean(this.save);
        this.putTag(this.tag);
        this.putByte((byte) this.responseType.ordinal());
    }
}