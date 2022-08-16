package cn.nukkit.network.protocol.types;

import cn.nukkit.math.BlockVector3;
import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class BlockChangeEntry {

    BlockVector3 position;
    int runtimeId;
    int updateFlags;
    long messageEntityId;
    MessageType messageType;

    public enum MessageType {
        NONE,
        CREATE,
        DESTROY
    }
}