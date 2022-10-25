package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNormalStoneStairs extends Item {

    public ItemNormalStoneStairs() {
        this(0, 1);
    }

    public ItemNormalStoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemNormalStoneStairs(Integer meta, int count) {
        super(ItemID.NORMAL_STONE_STAIRS, meta, count, "Normal Stone Stairs");
        this.block = Block.get(BlockID.NORMAL_STONE_STAIRS, meta);
    }
}