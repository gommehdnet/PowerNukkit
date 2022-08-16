package cn.nukkit.network.protocol.types;

import cn.nukkit.item.Item;
import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class TransactionAction {

    TransactionActionSourceType sourceType;
    WindowIDVarInt inventoryId;
    int flags;
    int action;
    int slot;
    Item oldItem;
    Item newItem;
}