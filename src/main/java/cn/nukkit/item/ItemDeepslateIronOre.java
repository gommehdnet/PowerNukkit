package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateIronOre extends Item {

    public ItemDeepslateIronOre() {
        this(0, 1);
    }

    public ItemDeepslateIronOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateIronOre(Integer meta, int count) {
        super(ItemID.DEEPSLATE_IRON_ORE, meta, count, "Deepslate Iron Ore");
        this.block = Block.get(BlockID.DEEPSLATE_IRON_ORE, meta);
    }
}