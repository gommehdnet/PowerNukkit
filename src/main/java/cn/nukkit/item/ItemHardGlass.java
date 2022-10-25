package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHardGlass extends Item {

    public ItemHardGlass() {
        this(0, 1);
    }

    public ItemHardGlass(Integer meta) {
        this(meta, 1);
    }

    public ItemHardGlass(Integer meta, int count) {
        super(ItemID.HARD_GLASS, meta, count, "Hard Glass");
        this.block = Block.get(BlockID.HARD_GLASS, meta);
    }
}