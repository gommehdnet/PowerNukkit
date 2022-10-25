package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveLog extends Item {

    public ItemMangroveLog() {
        this(0, 1);
    }

    public ItemMangroveLog(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveLog(Integer meta, int count) {
        super(ItemID.MANGROVE_LOG, meta, count, "Mangrove Log");
        this.block = Block.get(BlockID.MANGROVE_LOG, meta);
    }
}