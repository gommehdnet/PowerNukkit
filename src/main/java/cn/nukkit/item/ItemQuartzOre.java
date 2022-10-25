package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemQuartzOre extends Item {

    public ItemQuartzOre() {
        this(0, 1);
    }

    public ItemQuartzOre(Integer meta) {
        this(meta, 1);
    }

    public ItemQuartzOre(Integer meta, int count) {
        super(ItemID.QUARTZ_ORE, meta, count, "Quartz Ore");
        this.block = Block.get(BlockID.QUARTZ_ORE, meta);
    }
}