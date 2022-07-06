package cn.nukkit.network.protocol;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Kaooot
 * @version 1.0
 */
@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public enum Protocol {

    UNKNOWN(-1, ""),
    V1_18_0(475, "1.18.0"),
    V1_18_10(486, "1.18.10"),
    V1_18_30(503, "1.18.30"),
    V1_19_0(527, "1.19.0");

    private final int version;
    private final String minecraftVersion;

    private static final Protocol[] VALUES = Protocol.values();

    public static Protocol latest() {
        return Protocol.VALUES[Protocol.VALUES.length - 1];
    }

    public static Protocol oldest() {
        return Protocol.VALUES[1];
    }

    public static Protocol byVersion(int version) {
        for (Protocol protocol : Protocol.VALUES) {
            if (protocol.version == version) {
                return protocol;
            }
        }

        return Protocol.UNKNOWN;
    }

    public static Protocol byMinecraftVersion(String minecraftVersion) {
        for (Protocol protocol : Protocol.VALUES) {
            if (protocol.minecraftVersion.equalsIgnoreCase(minecraftVersion)) {
                return protocol;
            }
        }

        return Protocol.UNKNOWN;
    }
}