package cn.nukkit.network.protocol.types;

import lombok.Value;

import java.util.UUID;

/**
 * @author SupremeMortal (Nukkit project)
 */
@Value
public class CommandOriginData {

    CommandOriginType type;
    UUID uuid;
    String requestId;
    long entityUniqueId;
}