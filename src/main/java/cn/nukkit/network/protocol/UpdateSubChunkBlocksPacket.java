package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.BlockChangeEntry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class UpdateSubChunkBlocksPacket extends DataPacket {

    public int chunkX;
    public int chunkY;
    public int chunkZ;

    public List<BlockChangeEntry> standardBlocks = new ObjectArrayList<>();
    public List<BlockChangeEntry> extraBlocks = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.UPDATE_SUBCHUNK_BLOCKS_PACKET;
    }

    @Override
    public void decode() {
        this.chunkX = this.getVarInt();
        this.chunkY = (int) this.getUnsignedVarInt();
        this.chunkZ = this.getVarInt();

        int count = (int) this.getUnsignedVarInt();

        for (int i = 0; i < count; i++) {
            this.standardBlocks.add(new BlockChangeEntry(this.getBlockVector3(), (int) this.getUnsignedVarInt(), (int) this.getUnsignedVarInt(), this.getUnsignedVarLong(), BlockChangeEntry.MessageType.values()[(int) this.getUnsignedVarInt()]));
        }

        count = (int) this.getUnsignedVarInt();

        for (int i = 0; i < count; i++) {
            this.extraBlocks.add(new BlockChangeEntry(this.getBlockVector3(), (int) this.getUnsignedVarInt(), (int) this.getUnsignedVarInt(), this.getUnsignedVarLong(), BlockChangeEntry.MessageType.values()[(int) this.getUnsignedVarInt()]));
        }
    }

    @Override
    public void encode() {
        this.reset();

        this.putVarInt(this.chunkX);
        this.putUnsignedVarInt(this.chunkY);
        this.putVarInt(this.chunkZ);

        this.putUnsignedVarInt(this.standardBlocks.size());

        for (BlockChangeEntry entry : this.standardBlocks) {
            this.putBlockVector3(entry.getPosition());
            this.putUnsignedVarInt(entry.getRuntimeId());
            this.putUnsignedVarInt(entry.getUpdateFlags());
            this.putUnsignedVarLong(entry.getMessageEntityId());
            this.putUnsignedVarInt(entry.getMessageType().ordinal());
        }

        this.putUnsignedVarInt(this.extraBlocks.size());

        for (BlockChangeEntry entry : this.extraBlocks) {
            this.putBlockVector3(entry.getPosition());
            this.putUnsignedVarInt(entry.getRuntimeId());
            this.putUnsignedVarInt(entry.getUpdateFlags());
            this.putUnsignedVarLong(entry.getMessageEntityId());
            this.putUnsignedVarInt(entry.getMessageType().ordinal());
        }
    }
}