package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;
import cn.nukkit.network.protocol.types.BlockSyncType;
import cn.nukkit.utils.BedrockMappingUtil;

/**
 * @author Kaooot
 * @version 1.0
 */
public class UpdateBlockSyncedPacket extends UpdateBlockPacket {

    public long entityUniqueId;
    public BlockSyncType transitionType;

    @Override
    public byte pid() {
        return ProtocolInfo.UPDATE_BLOCK_SYNCED_PACKET;
    }

    @Override
    public void decode() {
        final BlockVector3 position = this.getBlockVector3();

        this.x = position.getX();
        this.y = position.getY();
        this.z = position.getZ();
        this.blockRuntimeId = BedrockMappingUtil.translateBlockRuntimeId(this.protocolVersion, (int) this.getUnsignedVarInt(), true);
        this.flags = (int) this.getUnsignedVarInt();
        this.dataLayer = (int) this.getUnsignedVarInt();
        this.entityUniqueId = this.getUnsignedVarLong();
    }

    @Override
    public void encode() {
        this.reset();
        this.putBlockVector3(this.x, this.y, this.z);
        this.putUnsignedVarInt(BedrockMappingUtil.translateBlockRuntimeId(this.protocolVersion, this.blockRuntimeId, true));
        this.putUnsignedVarInt(this.flags);
        this.putUnsignedVarInt(this.dataLayer);
        this.putUnsignedVarLong(this.entityUniqueId);
        this.putByte((byte) this.transitionType.ordinal());
    }
}