package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNetherGoldOre extends Item {

    public ItemNetherGoldOre() {
        this(0, 1);
    }

    public ItemNetherGoldOre(Integer meta) {
        this(meta, 1);
    }

    public ItemNetherGoldOre(Integer meta, int count) {
        super(ItemID.NETHER_GOLD_ORE, meta, count, "Nether Gold Ore");
        this.block = Block.get(BlockID.NETHER_GOLD_ORE, meta);
    }
}