package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateDiamondOre extends Item {

    public ItemDeepslateDiamondOre() {
        this(0, 1);
    }

    public ItemDeepslateDiamondOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateDiamondOre(Integer meta, int count) {
        super(ItemID.DEEPSLATE_DIAMOND_ORE, meta, count, "Deepslate Diamond Ore");
        this.block = Block.get(BlockID.DEEPSLATE_DIAMOND_ORE, meta);
    }
}