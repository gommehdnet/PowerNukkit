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