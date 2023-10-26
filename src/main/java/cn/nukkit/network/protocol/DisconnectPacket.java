package cn.nukkit.network.protocol;

import lombok.ToString;

/**
 * @since 15-10-12
 */
@ToString
public class DisconnectPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.DISCONNECT_PACKET;

    public boolean hideDisconnectionScreen = false;
    public String message;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
        if (this.protocolVersion >= Protocol.V1_20_40.version()) {
            this.getVarInt(); // disconnect fail reason
        }
        this.hideDisconnectionScreen = this.getBoolean();
        this.message = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        if (this.protocolVersion >= Protocol.V1_20_40.version()) {
            this.putVarInt(0); // disconnect fail reason
        }
        this.putBoolean(this.hideDisconnectionScreen);
        if (!this.hideDisconnectionScreen) {
            this.putString(this.message);
        }
    }


}
