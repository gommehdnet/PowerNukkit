package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.ModalFormCancelReason;
import lombok.ToString;

@ToString
public class ModalFormResponsePacket extends DataPacket {

    public int formId;
    public String data;
    public ModalFormCancelReason cancelReason;

    @Override
    public byte pid() {
        return ProtocolInfo.MODAL_FORM_RESPONSE_PACKET;
    }

    @Override
    public void decode() {
        this.formId = (int) this.getUnsignedVarInt();
        this.data = this.getString(); //Data will be null if player close form without submit (by cross button or ESC)

        if (this.protocolVersion >= Protocol.V1_19_20.version()) {
            this.cancelReason = ModalFormCancelReason.values()[this.getByte()];
        }
    }

    @Override
    public void encode() {
        this.putUnsignedVarInt(this.formId);
        this.putString(this.data);

        if (this.protocolVersion >= Protocol.V1_19_20.version()) {
            this.putByte((byte) this.cancelReason.ordinal());
        }
    }
}