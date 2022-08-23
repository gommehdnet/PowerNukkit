package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ServerStatsPacket extends DataPacket {

    public float serverTime;
    public float networkTime;

    @Override
    public byte pid() {
        return ProtocolInfo.SERVER_STATS_PACKET;
    }

    @Override
    public void decode() {
        this.serverTime = this.getLFloat();
        this.networkTime = this.getLFloat();
    }

    @Override
    public void encode() {
        this.reset();
        this.putLFloat(this.serverTime);
        this.putLFloat(this.networkTime);
    }
}