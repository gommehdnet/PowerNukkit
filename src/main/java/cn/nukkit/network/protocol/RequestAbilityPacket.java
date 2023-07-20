package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.Ability;
import cn.nukkit.network.protocol.types.AbilityType;

/**
 * @author Kaooot
 * @version 1.0
 */
public class RequestAbilityPacket extends DataPacket {

    public Ability ability;
    public AbilityType type;
    public boolean boolValue;
    public float floatValue;

    @Override
    public byte pid() {
        return ProtocolInfo.REQUEST_ABILITY_PACKET;
    }

    @Override
    public void decode() {
        this.ability = Ability.values()[this.protocolVersion >= Protocol.V1_20_10.version() ? this.getByte() : this.getVarInt()];
        this.type = AbilityType.values()[this.getByte()];
        this.boolValue = this.getBoolean();
        this.floatValue = this.getLFloat();
    }

    @Override
    public void encode() {
        this.reset();
        if (this.protocolVersion >= Protocol.V1_20_10.version()) {
            this.putByte((byte) this.ability.ordinal());
        } else {
            this.putVarInt(this.ability.ordinal());
        }
        this.putByte((byte) this.type.ordinal());
        this.putBoolean(this.boolValue);
        this.putLFloat(this.floatValue);
    }
}