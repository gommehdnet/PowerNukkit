package cn.nukkit.network.protocol;

import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author Kaooot
 * @version 1.0
 */
public class UpdateBlockPropertiesPacket extends DataPacket {

    public CompoundTag properties;

    @Override
    public byte pid() {
        return ProtocolInfo.UPDATE_BLOCK_PROPERTIES_PACKET;
    }

    @Override
    public void decode() {
        this.properties = this.getTag();
    }

    @Override
    public void encode() {
        this.reset();
        this.putTag(this.properties);
    }
}