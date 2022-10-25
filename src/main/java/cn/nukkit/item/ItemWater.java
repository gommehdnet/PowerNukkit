package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWater extends Item {

    public ItemWater() {
        this(0, 1);
    }

    public ItemWater(Integer meta) {
        this(meta, 1);
    }

    public ItemWater(Integer meta, int count) {
        super(ItemID.WATER, meta, count, "Water");
        this.block = Block.get(BlockID.WATER, meta);
    }
}