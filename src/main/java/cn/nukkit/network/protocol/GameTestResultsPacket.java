package cn.nukkit.network.protocol;

/**
 * @author Kaooot
 * @version 1.0
 */
public class GameTestResultsPacket extends DataPacket {

    public boolean succeeded;
    public String error;
    public String name;

    @Override
    public byte pid() {
        return ProtocolInfo.GAME_TEST_RESULTS_PACKET;
    }

    @Override
    public void decode() {
        this.succeeded = this.getBoolean();
        this.error = this.getString();
        this.name = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putBoolean(this.succeeded);
        this.putString(this.error);
        this.putString(this.name);
    }
}