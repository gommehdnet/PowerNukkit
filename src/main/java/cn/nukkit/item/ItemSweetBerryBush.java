package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSweetBerryBush extends Item {

    public ItemSweetBerryBush() {
        this(0, 1);
    }

    public ItemSweetBerryBush(Integer meta) {
        this(meta, 1);
    }

    public ItemSweetBerryBush(Integer meta, int count) {
        super(ItemID.SWEET_BERRY_BUSH, meta, count, "Sweet Berry Bush");
        this.block = Block.get(BlockID.SWEET_BERRY_BUSH, meta);
    }
}