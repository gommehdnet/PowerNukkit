package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ShowStoreOfferPacket extends DataPacket {

    public String offerId;
    public boolean showAll;

    @Override
    public byte pid() {
        return ProtocolInfo.SHOW_STORE_OFFER_PACKET;
    }

    @Override
    public void decode() {
        this.offerId = this.getString();
        this.showAll = this.getBoolean();
    }

    @Override
    public void encode() {
        this.putString(this.offerId);
        this.putBoolean(this.showAll);
    }
}