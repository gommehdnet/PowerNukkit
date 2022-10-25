package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStainedGlass extends Item {

    public ItemStainedGlass() {
        this(0, 1);
    }

    public ItemStainedGlass(Integer meta) {
        this(meta, 1);
    }

    public ItemStainedGlass(Integer meta, int count) {
        super(ItemID.STAINED_GLASS, meta, count, "Stained Glass");
        this.block = Block.get(BlockID.STAINED_GLASS, meta);
    }
}