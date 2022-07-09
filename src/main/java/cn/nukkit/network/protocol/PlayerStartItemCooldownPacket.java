package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class PlayerStartItemCooldownPacket extends DataPacket {

    public String category;
    public int duration;

    @Override
    public byte pid() {
        return ProtocolInfo.PLAYER_START_ITEM_COOLDOWN_PACKET;
    }

    @Override
    public void decode() {
        this.category = this.getString();
        this.duration = (int) this.getUnsignedVarInt();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.category);
        this.putUnsignedVarInt(this.duration);
    }
}