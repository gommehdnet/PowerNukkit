package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedOakLog extends Item {

    public ItemStrippedOakLog() {
        this(0, 1);
    }

    public ItemStrippedOakLog(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedOakLog(Integer meta, int count) {
        super(ItemID.STRIPPED_OAK_LOG, meta, count, "Stripped Oak Log");
        this.block = Block.get(BlockID.STRIPPED_OAK_LOG, meta);
    }
}