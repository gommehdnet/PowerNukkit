package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ChangeMobPropertyPacket extends DataPacket {

    public long entityUniqueId;
    public String property;
    public boolean boolValue;
    public String stringValue;
    public int intValue;
    public float floatValue;

    @Override
    public byte pid() {
        return ProtocolInfo.CHANGE_MOB_PROPERTY_PACKET;
    }

    @Override
    public void decode() {
        this.entityUniqueId = this.getUnsignedVarLong();
        this.property = this.getString();
        this.boolValue = this.getBoolean();
        this.stringValue = this.getString();
        this.intValue = this.getVarInt();
        this.floatValue = this.getLFloat();
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarLong(this.entityUniqueId);
        this.putString(this.property);
        this.putBoolean(this.boolValue);
        this.putString(this.stringValue);
        this.putVarInt(this.intValue);
        this.putLFloat(this.floatValue);
    }
}