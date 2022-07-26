package cn.nukkit.level.particle;

import cn.nukkit.block.Block;
import cn.nukkit.level.GlobalBlockPalette;
import cn.nukkit.math.BlockFace;
import cn.nukkit.math.Vector3;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.LevelEventPacket;
import cn.nukkit.utils.BedrockMappingUtil;

public class PunchBlockParticle extends ProtocolParticle {

    protected final int data;

    private BlockFace face;

    public PunchBlockParticle(Vector3 pos, Block block, BlockFace face) {
        this(pos, block.getId(), block.getDamage(), face);

        this.face = face;
    }

    public PunchBlockParticle(Vector3 pos, int blockId, int blockDamage, BlockFace face) {
        super(pos.x, pos.y, pos.z);
        this.data = GlobalBlockPalette.getOrCreateRuntimeId(blockId, blockDamage);
        this.face = face;
    }

    @Override
    public DataPacket[] encode(final int protocol) {
        LevelEventPacket pk = new LevelEventPacket();
        pk.evid = LevelEventPacket.EVENT_PARTICLE_PUNCH_BLOCK;
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.data = BedrockMappingUtil.translateBlockRuntimeId(protocol, this.data, true) | (this.face.getIndex() << 24);

        return new DataPacket[]{pk};
    }
}