package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.MultiplayerMode;

/**
 * @author Kaooot
 * @version 1.0
 */
public class MultiplayerSettingsPacket extends DataPacket {

    public MultiplayerMode mode;

    @Override
    public byte pid() {
        return ProtocolInfo.MULTIPLAYER_SETTINGS_PACKET;
    }

    @Override
    public void decode() {
        this.mode = MultiplayerMode.values()[this.getByte()];
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.mode.ordinal());
    }
}