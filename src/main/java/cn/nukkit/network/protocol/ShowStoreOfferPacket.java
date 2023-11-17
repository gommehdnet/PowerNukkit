package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.StoreOfferRedirectType;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ShowStoreOfferPacket extends DataPacket {

    public String offerId;
    public boolean showAll;
    public StoreOfferRedirectType redirectType;

    @Override
    public byte pid() {
        return ProtocolInfo.SHOW_STORE_OFFER_PACKET;
    }

    @Override
    public void decode() {
        this.offerId = this.getString();

        if (this.protocolVersion < Protocol.V1_20_50.version()) {
            this.showAll = this.getBoolean();
        } else {
            this.redirectType = StoreOfferRedirectType.values()[this.getByte()];
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.offerId);
        if (this.protocolVersion < Protocol.V1_20_50.version()) {
            this.putBoolean(this.showAll);
        } else {
            this.putByte((byte) this.redirectType.ordinal());
        }
    }
}