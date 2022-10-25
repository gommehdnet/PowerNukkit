package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonStairs extends Item {

    public ItemCrimsonStairs() {
        this(0, 1);
    }

    public ItemCrimsonStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonStairs(Integer meta, int count) {
        super(ItemID.CRIMSON_STAIRS, meta, count, "Crimson Stairs");
        this.block = Block.get(BlockID.CRIMSON_STAIRS, meta);
    }
}