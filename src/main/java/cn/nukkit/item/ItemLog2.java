package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLog2 extends Item {

    public ItemLog2() {
        this(0, 1);
    }

    public ItemLog2(Integer meta) {
        this(meta, 1);
    }

    public ItemLog2(Integer meta, int count) {
        super(ItemID.LOG2, meta, count, "Log2");
        this.block = Block.get(BlockID.LOG2, meta);
    }
}