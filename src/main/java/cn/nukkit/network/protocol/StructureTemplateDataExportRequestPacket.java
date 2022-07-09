package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;
import cn.nukkit.network.protocol.types.StructureSettings;
import cn.nukkit.network.protocol.types.StructureTemplateRequestType;

/**
 * @author Kaooot
 * @version 1.0
 */
public class StructureTemplateDataExportRequestPacket extends DataPacket {

    public String name;
    public BlockVector3 position;
    public StructureSettings settings;
    public StructureTemplateRequestType requestType;

    @Override
    public byte pid() {
        return ProtocolInfo.STRUCTURE_TEMPLATE_DATA_EXPORT_REQUEST_PACKET;
    }

    @Override
    public void decode() {
        this.name = this.getString();
        this.position = this.getBlockVector3();
        this.settings = this.getStructureSettings();
        this.requestType = StructureTemplateRequestType.values()[this.getByte()];
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.name);
        this.putBlockVector3(this.position);
        this.putStructureSettings(this.settings);
        this.putByte((byte) this.requestType.ordinal());
    }
}