package cn.nukkit.level.particle;

import cn.nukkit.network.protocol.DataPacket;

/**
 * @author Kaooot
 * @version 1.0
 */
public abstract class ProtocolParticle extends Particle {

    public ProtocolParticle() {
        super(0, 0, 0);
    }

    public ProtocolParticle(double x) {
        super(x, 0, 0);
    }

    public ProtocolParticle(double x, double y) {
        super(x, y, 0);
    }

    public ProtocolParticle(double x, double y, double z) {
        super(x, y, z);
    }

    public abstract DataPacket[] encode(final int protocol);

    @Override
    public DataPacket[] encode() {
        return DataPacket.EMPTY_ARRAY;
    }
}