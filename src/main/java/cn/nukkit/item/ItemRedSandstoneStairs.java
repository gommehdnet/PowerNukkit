package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedSandstoneStairs extends Item {

    public ItemRedSandstoneStairs() {
        this(0, 1);
    }

    public ItemRedSandstoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemRedSandstoneStairs(Integer meta, int count) {
        super(ItemID.RED_SANDSTONE_STAIRS, meta, count, "Red Sandstone Stairs");
        this.block = Block.get(BlockID.RED_SANDSTONE_STAIRS, meta);
    }
}