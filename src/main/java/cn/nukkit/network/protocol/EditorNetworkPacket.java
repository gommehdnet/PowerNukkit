package cn.nukkit.network.protocol;

import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;

import java.io.IOException;

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
        this.reset();
        try {
            this.put(NBTIO.writeNetwork(this.payload));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}