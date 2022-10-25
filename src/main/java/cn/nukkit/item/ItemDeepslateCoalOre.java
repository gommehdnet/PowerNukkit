package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateCoalOre extends Item {

    public ItemDeepslateCoalOre() {
        this(0, 1);
    }

    public ItemDeepslateCoalOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateCoalOre(Integer meta, int count) {
        super(ItemID.DEEPSLATE_COAL_ORE, meta, count, "Deepslate Coal Ore");
        this.block = Block.get(BlockID.DEEPSLATE_COAL_ORE, meta);
    }
}