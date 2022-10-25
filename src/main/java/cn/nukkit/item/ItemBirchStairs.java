package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchStairs extends Item {

    public ItemBirchStairs() {
        this(0, 1);
    }

    public ItemBirchStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchStairs(Integer meta, int count) {
        super(ItemID.BIRCH_STAIRS, meta, count, "Birch Stairs");
        this.block = Block.get(BlockID.BIRCH_STAIRS, meta);
    }
}