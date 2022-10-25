package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndBricks extends Item {

    public ItemEndBricks() {
        this(0, 1);
    }

    public ItemEndBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemEndBricks(Integer meta, int count) {
        super(ItemID.END_BRICKS, meta, count, "End Bricks");
        this.block = Block.get(BlockID.END_BRICKS, meta);
    }
}