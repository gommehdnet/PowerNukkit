package cn.nukkit.network.protocol.types;

import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class SubChunkEntry {

    byte dx;
    byte dy;
    byte dz;
    Result result;
    byte[] payload;
    HeightMapType heightMapType;
    byte[] heightMap;
    boolean withCaching;
    long blobId;

    public enum Result {
        UNDEFINED,
        SUCCESS,
        CHUNK_NOT_FOUND,
        INVALID_DIMENSION,
        PLAYER_NOT_FOUND,
        Y_INDEX_OUT_OF_BOUNDS,
        SUCCESS_ALL_AIR
    }

    public enum HeightMapType {
        NO_DATA,
        HAS_DATA,
        TOO_HIGH,
        TOO_LOW
    }
}