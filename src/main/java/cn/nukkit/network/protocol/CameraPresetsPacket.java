package cn.nukkit.network.protocol;

import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;

import java.io.IOException;

/**
 * @author Kaooot
 * @version 1.0
 */
public class CameraPresetsPacket extends DataPacket {

    public CompoundTag data;

    @Override
    public byte pid() {
        return ProtocolInfo.CAMERA_PRESETS_PACKET;
    }

    @Override
    public void decode() {
        this.data = this.getTag();
    }

    @Override
    public void encode() {
        this.reset();
        try {
            this.put(NBTIO.writeNetwork(this.data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}