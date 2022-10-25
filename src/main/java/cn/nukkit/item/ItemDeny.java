package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeny extends Item {

    public ItemDeny() {
        this(0, 1);
    }

    public ItemDeny(Integer meta) {
        this(meta, 1);
    }

    public ItemDeny(Integer meta, int count) {
        super(ItemID.DENY, meta, count, "Deny");
        this.block = Block.get(BlockID.DENY, meta);
    }
}