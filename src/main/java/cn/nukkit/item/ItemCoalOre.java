package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoalOre extends Item {

    public ItemCoalOre() {
        this(0, 1);
    }

    public ItemCoalOre(Integer meta) {
        this(meta, 1);
    }

    public ItemCoalOre(Integer meta, int count) {
        super(ItemID.COAL_ORE, meta, count, "Coal Ore");
        this.block = Block.get(BlockID.COAL_ORE, meta);
    }
}