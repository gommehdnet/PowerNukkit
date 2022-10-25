package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedGraniteStairs extends Item {

    public ItemPolishedGraniteStairs() {
        this(0, 1);
    }

    public ItemPolishedGraniteStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedGraniteStairs(Integer meta, int count) {
        super(ItemID.POLISHED_GRANITE_STAIRS, meta, count, "Polished Granite Stairs");
        this.block = Block.get(BlockID.POLISHED_GRANITE_STAIRS, meta);
    }
}