package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;
import cn.nukkit.math.Vector2;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.ToString;

import java.util.List;

@ToString
public class NetworkChunkPublisherUpdatePacket extends DataPacket {

    public BlockVector3 position;
    public int radius;
    public List<Vector2> savedChunks = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.NETWORK_CHUNK_PUBLISHER_UPDATE_PACKET;
    }

    @Override
    public void decode() {
        this.position = this.getSignedBlockPosition();
        this.radius = (int) this.getUnsignedVarInt();

        int savedChunksLength = this.getLInt();

        for (int i = 0; i < savedChunksLength; i++) {
            final int x = this.getVarInt();
            final int y = this.getVarInt();

            this.savedChunks.add(new Vector2(x, y));
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putSignedBlockPosition(this.position);
        this.putUnsignedVarInt(this.radius);

        this.putLInt(this.savedChunks.size());

        for (Vector2 savedChunk : this.savedChunks) {
            this.putVarInt((int) savedChunk.getX());
            this.putVarInt((int) savedChunk.getY());
        }
    }
}