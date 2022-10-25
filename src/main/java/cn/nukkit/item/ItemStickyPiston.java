package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStickyPiston extends Item {

    public ItemStickyPiston() {
        this(0, 1);
    }

    public ItemStickyPiston(Integer meta) {
        this(meta, 1);
    }

    public ItemStickyPiston(Integer meta, int count) {
        super(ItemID.STICKY_PISTON, meta, count, "Sticky Piston");
        this.block = Block.get(BlockID.STICKY_PISTON, meta);
    }
}