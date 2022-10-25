package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemQuartzBricks extends Item {

    public ItemQuartzBricks() {
        this(0, 1);
    }

    public ItemQuartzBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemQuartzBricks(Integer meta, int count) {
        super(ItemID.QUARTZ_BRICKS, meta, count, "Quartz Bricks");
        this.block = Block.get(BlockID.QUARTZ_BRICKS, meta);
    }
}