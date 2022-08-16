package cn.nukkit.network.protocol;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class PurchaseReceiptPacket extends DataPacket {

    public final List<String> receipts = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.PURCHASE_RECEIPT_PACKET;
    }

    @Override
    public void decode() {
        long receiptsLength = this.getUnsignedVarInt();

        for (int i = 0; i < receiptsLength; i++) {
            String receipt = this.getString();

            this.receipts.add(receipt);
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarInt(this.receipts.size());

        for (String receipt : this.receipts) {
            this.putString(receipt);
        }
    }
}