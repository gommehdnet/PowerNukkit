package cn.nukkit.network.protocol;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ClientCacheBlobStatusPacket extends DataPacket {

    public LongList nacks = new LongArrayList();
    public LongList acks = new LongArrayList();

    @Override
    public byte pid() {
        return ProtocolInfo.CLIENT_CACHE_BLOB_STATUS_PACKET;
    }

    @Override
    public void decode() {
        long misses = this.getUnsignedVarInt();
        long haves = this.getUnsignedVarInt();

        for (int i = 0; i < misses; i++) {
            long missing = this.getLLong();

            this.nacks.add(missing);
        }

        for (int i = 0; i < haves; i++) {
            long have = this.getLLong();

            this.acks.add(have);
        }
    }

    @Override
    public void encode() {
        this.putUnsignedVarInt(this.nacks.size());
        this.putUnsignedVarInt(this.acks.size());

        for (long missing : this.nacks) {
            this.putLLong(missing);
        }

        for (long have : this.acks) {
            this.putLLong(have);
        }
    }
}