package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;

/**
 * @author Kaooot
 * @version 1.0
 */
public class OpenSignPacket extends DataPacket {

    public BlockVector3 position;
    public boolean frontSide;

    @Override
    public byte pid() {
        return ProtocolInfo.OPEN_SIGN_PACKET;
    }

    @Override
    public void decode() {
        this.position = this.getBlockVector3();
        this.frontSide = this.getBoolean();
    }

    @Override
    public void encode() {
        this.reset();
        this.putBlockVector3(this.position);
        this.putBoolean(this.frontSide);
    }
}