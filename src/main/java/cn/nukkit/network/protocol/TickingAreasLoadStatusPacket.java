package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class TickingAreasLoadStatusPacket extends DataPacket {

    public boolean preload;

    @Override
    public byte pid() {
        return ProtocolInfo.TICKING_AREAS_LOAD_STATUS_PACKET;
    }

    @Override
    public void decode() {
        this.preload = this.getBoolean();
    }

    @Override
    public void encode() {
        this.reset();
        this.putBoolean(this.preload);
    }
}