package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCobbledDeepslateStairs extends Item {

    public ItemCobbledDeepslateStairs() {
        this(0, 1);
    }

    public ItemCobbledDeepslateStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemCobbledDeepslateStairs(Integer meta, int count) {
        super(ItemID.COBBLED_DEEPSLATE_STAIRS, meta, count, "Cobbled Deepslate Stairs");
        this.block = Block.get(BlockID.COBBLED_DEEPSLATE_STAIRS, meta);
    }
}