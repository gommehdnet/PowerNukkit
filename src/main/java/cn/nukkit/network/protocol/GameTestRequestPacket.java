package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;
import cn.nukkit.network.protocol.types.GameTestRequestRotation;

/**
 * @author Kaooot
 * @version 1.0
 */
public class GameTestRequestPacket extends DataPacket {

    public int maxTestsPerBatch;
    public int repetitions;
    public GameTestRequestRotation rotation;
    public boolean stopOnError;
    public BlockVector3 position;
    public int testsPerRow;
    public String name;

    @Override
    public byte pid() {
        return ProtocolInfo.GAME_TEST_REQUEST_PACKET;
    }

    @Override
    public void decode() {
        this.maxTestsPerBatch = (int) this.getUnsignedVarInt();
        this.repetitions = (int) this.getUnsignedVarInt();
        this.rotation = GameTestRequestRotation.values()[this.getByte()];
        this.stopOnError = this.getBoolean();
        this.position = this.getBlockVector3();
        this.testsPerRow = (int) this.getUnsignedVarInt();
        this.name = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarInt(this.maxTestsPerBatch);
        this.putUnsignedVarInt(this.repetitions);
        this.putByte((byte) this.rotation.ordinal());
        this.putBoolean(this.stopOnError);
        this.putBlockVector3(this.position);
        this.putUnsignedVarInt(this.testsPerRow);
        this.putString(this.name);
    }
}