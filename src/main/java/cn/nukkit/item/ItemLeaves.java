package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLeaves extends Item {

    public ItemLeaves() {
        this(0, 1);
    }

    public ItemLeaves(Integer meta) {
        this(meta, 1);
    }

    public ItemLeaves(Integer meta, int count) {
        super(ItemID.LEAVES, meta, count, "Leaves");
        this.block = Block.get(BlockID.LEAVES, meta);
    }
}