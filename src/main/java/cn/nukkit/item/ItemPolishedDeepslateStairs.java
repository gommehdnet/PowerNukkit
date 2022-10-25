package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedDeepslateStairs extends Item {

    public ItemPolishedDeepslateStairs() {
        this(0, 1);
    }

    public ItemPolishedDeepslateStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedDeepslateStairs(Integer meta, int count) {
        super(ItemID.POLISHED_DEEPSLATE_STAIRS, meta, count, "Polished Deepslate Stairs");
        this.block = Block.get(BlockID.POLISHED_DEEPSLATE_STAIRS, meta);
    }
}