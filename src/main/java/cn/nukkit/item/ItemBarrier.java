package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBarrier extends Item {

    public ItemBarrier() {
        this(0, 1);
    }

    public ItemBarrier(Integer meta) {
        this(meta, 1);
    }

    public ItemBarrier(Integer meta, int count) {
        super(ItemID.BARRIER, meta, count, "Barrier");
        this.block = Block.get(BlockID.BARRIER, meta);
    }
}