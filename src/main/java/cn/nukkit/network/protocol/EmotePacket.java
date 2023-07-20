package cn.nukkit.network.protocol;

import cn.nukkit.api.Since;
import lombok.ToString;

@ToString
public class EmotePacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.EMOTE_PACKET;

    @Since("1.3.0.0-PN")
    public long runtimeId;
    @Since("1.3.0.0-PN")
    public String emoteID;
    @Since("1.3.0.0-PN")
    public byte flags;
    public String xuid;
    public String platformId;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
        this.runtimeId = this.getEntityRuntimeId();
        this.emoteID = this.getString();

        if (this.protocolVersion >= Protocol.V1_20_0.version()) {
            this.xuid = this.getString();
            this.platformId = this.getString();
        }

        this.flags = (byte) this.getByte();
    }

    @Override
    public void encode() {
        this.reset();
        this.putEntityRuntimeId(this.runtimeId);
        this.putString(this.emoteID);

        if (this.protocolVersion >= Protocol.V1_20_0.version()) {
            this.putString(this.xuid);
            this.putString(this.platformId);
        }

        this.putByte(flags);
    }
}
