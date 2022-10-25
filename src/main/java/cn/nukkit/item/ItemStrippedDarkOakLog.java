package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedDarkOakLog extends Item {

    public ItemStrippedDarkOakLog() {
        this(0, 1);
    }

    public ItemStrippedDarkOakLog(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedDarkOakLog(Integer meta, int count) {
        super(ItemID.STRIPPED_DARK_OAK_LOG, meta, count, "Stripped Dark Oak Log");
        this.block = Block.get(BlockID.STRIPPED_DARK_OAK_LOG, meta);
    }
}