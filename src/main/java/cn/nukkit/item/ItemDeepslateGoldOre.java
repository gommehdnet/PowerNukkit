package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateGoldOre extends Item {

    public ItemDeepslateGoldOre() {
        this(0, 1);
    }

    public ItemDeepslateGoldOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateGoldOre(Integer meta, int count) {
        super(ItemID.DEEPSLATE_GOLD_ORE, meta, count, "Deepslate Gold Ore");
        this.block = Block.get(BlockID.DEEPSLATE_GOLD_ORE, meta);
    }
}