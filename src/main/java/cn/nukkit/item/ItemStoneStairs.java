package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStoneStairs extends Item {

    public ItemStoneStairs() {
        this(0, 1);
    }

    public ItemStoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemStoneStairs(Integer meta, int count) {
        super(ItemID.STONE_STAIRS, meta, count, "Stone Stairs");
        this.block = Block.get(BlockID.STONE_STAIRS, meta);
    }
}