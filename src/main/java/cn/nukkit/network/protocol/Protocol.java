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

    UNKNOWN(-1, "", -1),
    V1_18_0(475, "1.18.0", 10),
    V1_18_10(486, "1.18.10", 10),
    V1_18_30(503, "1.18.30", 10),
    V1_19_0(527, "1.19.0", 10),
    V1_19_10(534, "1.19.10", 10),
    V1_19_20(544, "1.19.20", 10),
    V1_19_21(545, "1.19.21", 10),
    V1_19_30(554, "1.19.30", 11);

    private final int version;
    private final String minecraftVersion;
    private final int rakNetVersion;

    public static final Protocol[] VALUES = Protocol.values();

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