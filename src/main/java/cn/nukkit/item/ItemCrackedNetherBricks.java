package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrackedNetherBricks extends Item {

    public ItemCrackedNetherBricks() {
        this(0, 1);
    }

    public ItemCrackedNetherBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemCrackedNetherBricks(Integer meta, int count) {
        super(ItemID.CRACKED_NETHER_BRICKS, meta, count, "Cracked Nether Bricks");
        this.block = Block.get(BlockID.CRACKED_NETHER_BRICKS, meta);
    }
}