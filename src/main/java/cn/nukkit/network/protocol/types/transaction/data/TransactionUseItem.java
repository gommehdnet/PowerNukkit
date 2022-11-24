package cn.nukkit.network.protocol.types.transaction.data;

import cn.nukkit.item.Item;
import cn.nukkit.math.BlockVector3;
import cn.nukkit.math.Vector3f;
import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class TransactionUseItem {

    TransactionUseItemActionType actionType;
    BlockVector3 blockPosition;
    int face;
    int hotbarSlot;
    Item heldItem;
    Vector3f playerPos;
    Vector3f clickPos;
    int blockRuntimeId;
}