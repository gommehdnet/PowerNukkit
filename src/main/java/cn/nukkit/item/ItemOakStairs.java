package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOakStairs extends Item {

    public ItemOakStairs() {
        this(0, 1);
    }

    public ItemOakStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemOakStairs(Integer meta, int count) {
        super(ItemID.OAK_STAIRS, meta, count, "Oak Stairs");
        this.block = Block.get(BlockID.OAK_STAIRS, meta);
    }
}