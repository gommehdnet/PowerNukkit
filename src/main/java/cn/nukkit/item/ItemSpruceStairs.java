package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpruceStairs extends Item {

    public ItemSpruceStairs() {
        this(0, 1);
    }

    public ItemSpruceStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceStairs(Integer meta, int count) {
        super(ItemID.SPRUCE_STAIRS, meta, count, "Spruce Stairs");
        this.block = Block.get(BlockID.SPRUCE_STAIRS, meta);
    }
}