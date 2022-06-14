package cn.nukkit.network;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.ProtocolInfo;
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
        this.ability = Ability.values()[this.getVarInt()];
        this.type = AbilityType.values()[this.getByte()];
        this.boolValue = this.getBoolean();
        this.floatValue = this.getLFloat();
    }

    @Override
    public void encode() {
        this.putVarInt(this.ability.ordinal());
        this.putByte((byte) this.type.ordinal());
        this.putBoolean(this.boolValue);
        this.putLFloat(this.floatValue);
    }
}