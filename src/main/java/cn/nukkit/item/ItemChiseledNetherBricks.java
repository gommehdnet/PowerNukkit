package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChiseledNetherBricks extends Item {

    public ItemChiseledNetherBricks() {
        this(0, 1);
    }

    public ItemChiseledNetherBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemChiseledNetherBricks(Integer meta, int count) {
        super(ItemID.CHISELED_NETHER_BRICKS, meta, count, "Chiseled Nether Bricks");
        this.block = Block.get(BlockID.CHISELED_NETHER_BRICKS, meta);
    }
}