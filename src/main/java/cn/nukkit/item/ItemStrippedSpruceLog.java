package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedSpruceLog extends Item {

    public ItemStrippedSpruceLog() {
        this(0, 1);
    }

    public ItemStrippedSpruceLog(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedSpruceLog(Integer meta, int count) {
        super(ItemID.STRIPPED_SPRUCE_LOG, meta, count, "Stripped Spruce Log");
        this.block = Block.get(BlockID.STRIPPED_SPRUCE_LOG, meta);
    }
}