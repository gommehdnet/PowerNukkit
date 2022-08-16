package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.ModalFormCancelReason;
import lombok.ToString;

@ToString
public class ModalFormResponsePacket extends DataPacket {

    public int formId;
    public String data = "";
    public ModalFormCancelReason cancelReason;

    @Override
    public byte pid() {
        return ProtocolInfo.MODAL_FORM_RESPONSE_PACKET;
    }

    @Override
    public void decode() {
        this.formId = this.getVarInt();

        if (this.protocolVersion >= Protocol.V1_19_20.version()) {
            if (this.getBoolean()) {
                this.data = this.getString();
            }
        } else {
            this.data = this.getString();
        }

        if (this.protocolVersion >= Protocol.V1_19_20.version()) {
            if (this.getBoolean()) {
                this.cancelReason = ModalFormCancelReason.values()[this.getByte()];
            }
        }
    }

    @Override
    public void encode() {
        this.putVarInt(this.formId);

        if (this.protocolVersion >= Protocol.V1_19_20.version()) {
            final boolean isNotEmpty = !this.data.isEmpty();

            this.putBoolean(isNotEmpty);

            if (isNotEmpty) {
                this.putString(this.data);
            }
        } else {
            this.putString(this.data);
        }

        if (this.protocolVersion >= Protocol.V1_19_20.version()) {
            final boolean isNotNull = this.cancelReason != null;

            this.putBoolean(isNotNull);

            if (isNotNull) {
                this.putByte((byte) this.cancelReason.ordinal());
            }
        }
    }
}