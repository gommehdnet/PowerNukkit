package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedMangroveLog extends Item {

    public ItemStrippedMangroveLog() {
        this(0, 1);
    }

    public ItemStrippedMangroveLog(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedMangroveLog(Integer meta, int count) {
        super(ItemID.STRIPPED_MANGROVE_LOG, meta, count, "Stripped Mangrove Log");
        this.block = Block.get(BlockID.STRIPPED_MANGROVE_LOG, meta);
    }
}