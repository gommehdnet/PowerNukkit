package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDirtWithRoots extends Item {

    public ItemDirtWithRoots() {
        this(0, 1);
    }

    public ItemDirtWithRoots(Integer meta) {
        this(meta, 1);
    }

    public ItemDirtWithRoots(Integer meta, int count) {
        super(ItemID.DIRT_WITH_ROOTS, meta, count, "Dirt With Roots");
        this.block = Block.get(BlockID.DIRT_WITH_ROOTS, meta);
    }
}