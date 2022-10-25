package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedAndesiteStairs extends Item {

    public ItemPolishedAndesiteStairs() {
        this(0, 1);
    }

    public ItemPolishedAndesiteStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedAndesiteStairs(Integer meta, int count) {
        super(ItemID.POLISHED_ANDESITE_STAIRS, meta, count, "Polished Andesite Stairs");
        this.block = Block.get(BlockID.POLISHED_ANDESITE_STAIRS, meta);
    }
}