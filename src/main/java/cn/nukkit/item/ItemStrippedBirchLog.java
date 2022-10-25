package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedBirchLog extends Item {

    public ItemStrippedBirchLog() {
        this(0, 1);
    }

    public ItemStrippedBirchLog(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedBirchLog(Integer meta, int count) {
        super(ItemID.STRIPPED_BIRCH_LOG, meta, count, "Stripped Birch Log");
        this.block = Block.get(BlockID.STRIPPED_BIRCH_LOG, meta);
    }
}