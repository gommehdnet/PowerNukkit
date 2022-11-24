package cn.nukkit.network.protocol.types.transaction;

import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.types.WindowIDVarInt;
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