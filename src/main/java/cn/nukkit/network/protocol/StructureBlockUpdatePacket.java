package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;
import cn.nukkit.network.protocol.types.StructureBlockType;
import cn.nukkit.network.protocol.types.StructureRedstoneSaveMode;
import cn.nukkit.network.protocol.types.StructureSettings;
import lombok.ToString;

@ToString
public class StructureBlockUpdatePacket extends DataPacket {

    public BlockVector3 position;
    public String structureName;
    public String dataField;
    public boolean includePlayers;
    public boolean showBoundingBox;
    public StructureBlockType type;
    public StructureSettings settings;
    public StructureRedstoneSaveMode redstoneSaveMode;
    public boolean shouldTrigger;

    @Override
    public byte pid() {
        return ProtocolInfo.STRUCTURE_BLOCK_UPDATE_PACKET;
    }

    @Override
    public void decode() {
        this.position = this.getBlockVector3();
        this.structureName = this.getString();
        this.dataField = this.getString();
        this.includePlayers = this.getBoolean();
        this.showBoundingBox = this.getBoolean();
        this.type = StructureBlockType.values()[this.getByte()];
        this.settings = this.getStructureSettings();
        this.redstoneSaveMode = StructureRedstoneSaveMode.values()[this.getByte()];
        this.shouldTrigger = this.getBoolean();
    }

    @Override
    public void encode() {
        this.reset();
        this.putBlockVector3(this.position);
        this.putString(this.structureName);
        this.putString(this.dataField);
        this.putBoolean(this.includePlayers);
        this.putBoolean(this.showBoundingBox);
        this.putByte((byte) this.type.ordinal());
        this.putStructureSettings(this.settings);
        this.putByte((byte) this.redstoneSaveMode.ordinal());
        this.putBoolean(this.shouldTrigger);
    }
}