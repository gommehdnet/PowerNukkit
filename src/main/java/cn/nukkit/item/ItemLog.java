package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLog extends Item {

    public ItemLog() {
        this(0, 1);
    }

    public ItemLog(Integer meta) {
        this(meta, 1);
    }

    public ItemLog(Integer meta, int count) {
        super(ItemID.LOG, meta, count, "Log");
        this.block = Block.get(BlockID.LOG, meta);
    }
}