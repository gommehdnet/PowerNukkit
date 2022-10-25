package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedJungleLog extends Item {

    public ItemStrippedJungleLog() {
        this(0, 1);
    }

    public ItemStrippedJungleLog(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedJungleLog(Integer meta, int count) {
        super(ItemID.STRIPPED_JUNGLE_LOG, meta, count, "Stripped Jungle Log");
        this.block = Block.get(BlockID.STRIPPED_JUNGLE_LOG, meta);
    }
}