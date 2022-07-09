package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;
import cn.nukkit.network.protocol.types.SubChunkEntry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class SubChunkPacket extends DataPacket {

    public boolean cacheEnabled;
    public int dimension;
    public BlockVector3 origin;
    public List<SubChunkEntry> entries = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.SUBCHUNK_PACKET;
    }

    @Override
    public void decode() {
        this.cacheEnabled = this.getBoolean();
        this.dimension = (int) this.getUnsignedVarInt();
        this.origin = this.getBlockVector3();

        final int count = this.getLInt();

        for (int i = 0; i < count; i++) {
            final byte dx = (byte) this.getByte();
            final byte dy = (byte) this.getByte();
            final byte dz = (byte) this.getByte();
            final SubChunkEntry.Result result = SubChunkEntry.Result.values()[this.getByte()];
            final byte[] payload = this.getByteArray();
            final SubChunkEntry.HeightMapType heightMapType = SubChunkEntry.HeightMapType.values()[this.getByte()];
            final byte[] heightMap = this.getByteArray();
            final long blobId = this.cacheEnabled ? this.getLLong() : -1L;

            this.entries.add(new SubChunkEntry(dx, dy, dz, result, payload, heightMapType, heightMap, this.cacheEnabled, blobId));
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putBoolean(this.cacheEnabled);
        this.putUnsignedVarInt(this.dimension);
        this.putBlockVector3(this.origin);

        this.putLInt(this.entries.size());

        for (SubChunkEntry entry : this.entries) {
            this.putByte(entry.getDx());
            this.putByte(entry.getDy());
            this.putByte(entry.getDz());
            this.putByte((byte) entry.getResult().ordinal());
            this.putByteArray(entry.getPayload());
            this.putByte((byte) entry.getHeightMapType().ordinal());
            this.putByteArray(entry.getHeightMap());

            if (this.cacheEnabled) {
                this.putLLong(entry.getBlobId());
            }
        }
    }
}