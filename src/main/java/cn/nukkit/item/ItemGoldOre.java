package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGoldOre extends Item {

    public ItemGoldOre() {
        this(0, 1);
    }

    public ItemGoldOre(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldOre(Integer meta, int count) {
        super(ItemID.GOLD_ORE, meta, count, "Gold Ore");
        this.block = Block.get(BlockID.GOLD_ORE, meta);
    }
}