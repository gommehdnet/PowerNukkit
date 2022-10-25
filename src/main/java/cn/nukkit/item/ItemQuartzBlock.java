package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemQuartzBlock extends Item {

    public ItemQuartzBlock() {
        this(0, 1);
    }

    public ItemQuartzBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemQuartzBlock(Integer meta, int count) {
        super(ItemID.QUARTZ_BLOCK, meta, count, "Quartz Block");
        this.block = Block.get(BlockID.QUARTZ_BLOCK, meta);
    }
}