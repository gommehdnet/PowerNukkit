package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSandstoneStairs extends Item {

    public ItemSandstoneStairs() {
        this(0, 1);
    }

    public ItemSandstoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemSandstoneStairs(Integer meta, int count) {
        super(ItemID.SANDSTONE_STAIRS, meta, count, "Sandstone Stairs");
        this.block = Block.get(BlockID.SANDSTONE_STAIRS, meta);
    }
}