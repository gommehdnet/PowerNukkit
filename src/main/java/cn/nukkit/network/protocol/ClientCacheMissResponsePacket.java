package cn.nukkit.network.protocol;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ClientCacheMissResponsePacket extends DataPacket {

    public Long2ObjectMap<byte[]> blobs = new Long2ObjectOpenHashMap<>();

    @Override
    public byte pid() {
        return ProtocolInfo.CLIENT_CACHE_MISS_RESPONSE_PACKET;
    }

    @Override
    public void decode() {
        long blobsLength = this.getUnsignedVarInt();

        for (int i = 0; i < blobsLength; i++) {
            long key = this.getLong();
            byte[] blob = this.getByteArray();

            this.blobs.put(key, blob);
        }
    }

    @Override
    public void encode() {
        this.putUnsignedVarInt(this.blobs.size());

        for (Long2ObjectMap.Entry<byte[]> blob : this.blobs.long2ObjectEntrySet()) {
            this.putLLong(blob.getLongKey());
            this.putByteArray(blob.getValue());
        }
    }
}