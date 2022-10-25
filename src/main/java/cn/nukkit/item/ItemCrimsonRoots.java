package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonRoots extends Item {

    public ItemCrimsonRoots() {
        this(0, 1);
    }

    public ItemCrimsonRoots(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonRoots(Integer meta, int count) {
        super(ItemID.CRIMSON_ROOTS, meta, count, "Crimson Roots");
        this.block = Block.get(BlockID.CRIMSON_ROOTS, meta);
    }
}