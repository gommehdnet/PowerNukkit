package cn.nukkit.network.protocol;

import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author Kaooot
 * @version 1.0
 */
public class EditorNetworkPacket extends DataPacket {

    public CompoundTag payload;

    @Override
    public byte pid() {
        return ProtocolInfo.EDITOR_NETWORK_PACKET;
    }

    @Override
    public void decode() {
        this.payload = this.getTag();
    }

    @Override
    public void encode() {
        this.putTag(this.payload);
    }
}