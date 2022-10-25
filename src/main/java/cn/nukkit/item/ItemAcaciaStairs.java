package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaStairs extends Item {

    public ItemAcaciaStairs() {
        this(0, 1);
    }

    public ItemAcaciaStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaStairs(Integer meta, int count) {
        super(ItemID.ACACIA_STAIRS, meta, count, "Acacia Stairs");
        this.block = Block.get(BlockID.ACACIA_STAIRS, meta);
    }
}