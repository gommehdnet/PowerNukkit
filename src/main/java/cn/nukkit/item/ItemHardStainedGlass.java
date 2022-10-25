package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHardStainedGlass extends Item {

    public ItemHardStainedGlass() {
        this(0, 1);
    }

    public ItemHardStainedGlass(Integer meta) {
        this(meta, 1);
    }

    public ItemHardStainedGlass(Integer meta, int count) {
        super(ItemID.HARD_STAINED_GLASS, meta, count, "Hard Stained Glass");
        this.block = Block.get(BlockID.HARD_STAINED_GLASS, meta);
    }
}