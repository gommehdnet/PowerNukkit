package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class PacketSetDefaultGameType extends DataPacket{

    public int gamemode;

    @Override
    public byte pid() {
        return ProtocolInfo.SET_DEFAULT_GAME_TYPE_PACKET;
    }

    @Override
    public void decode() {
        this.gamemode = (int) this.getUnsignedVarInt();
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarInt(this.gamemode);
    }
}