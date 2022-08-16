package cn.nukkit.network.protocol.types;

import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class DimensionData {

    String id;
    int maxHeight;
    int minHeight;
    Generator generator;

    public enum Generator {
        LEGACY,
        OVERWORLD,
        FLAT,
        NETHER,
        END,
        VOID
    }
}