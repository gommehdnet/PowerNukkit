package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaterlily extends Item {

    public ItemWaterlily() {
        this(0, 1);
    }

    public ItemWaterlily(Integer meta) {
        this(meta, 1);
    }

    public ItemWaterlily(Integer meta, int count) {
        super(ItemID.WATERLILY, meta, count, "Waterlily");
        this.block = Block.get(BlockID.WATERLILY, meta);
    }
}