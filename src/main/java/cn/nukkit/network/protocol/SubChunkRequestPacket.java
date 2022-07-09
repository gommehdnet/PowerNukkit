package cn.nukkit.network.protocol;

import cn.nukkit.math.BlockVector3;
import cn.nukkit.network.protocol.types.SubChunkRequest;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class SubChunkRequestPacket extends DataPacket {

    public int dimension;
    public BlockVector3 origin;
    public List<SubChunkRequest> requests = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.SUBCHUNK_REQUEST_PACKET;
    }

    @Override
    public void decode() {
        this.dimension = (int) this.getUnsignedVarInt();
        this.origin = this.getBlockVector3();

        final int count = this.getLInt();

        for (int i = 0; i < count; i++) {
            this.requests.add(new SubChunkRequest((byte) this.getByte(), (byte) this.getByte(), (byte) this.getByte()));
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putUnsignedVarInt(this.dimension);
        this.putBlockVector3(this.origin);

        this.putLInt(this.requests.size());

        for (SubChunkRequest request : this.requests) {
            this.putByte(request.getDx());
            this.putByte(request.getDy());
            this.putByte(request.getDz());
        }
    }
}