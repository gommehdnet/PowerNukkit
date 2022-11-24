package cn.nukkit.network.protocol.types.transaction;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Kaooot
 * @version 1.0
 */
@Getter
@RequiredArgsConstructor
public enum TransactionActionSourceType {

    CONTAINER(0),
    GLOBAL(1),
    WORLD_INTERACTION(2),
    CREATIVE(3),
    CRAFT_SLOT(100),
    CRAFT(99999);

    private final int id;

    public static TransactionActionSourceType byId(final int id) {
        for (TransactionActionSourceType type : TransactionActionSourceType.values()) {
            if (type.getId() == id) {
                return type;
            }
        }

        return null;
    }
}