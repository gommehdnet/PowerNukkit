package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateCopperOre extends Item {

    public ItemDeepslateCopperOre() {
        this(0, 1);
    }

    public ItemDeepslateCopperOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateCopperOre(Integer meta, int count) {
        super(ItemID.DEEPSLATE_COPPER_ORE, meta, count, "Deepslate Copper Ore");
        this.block = Block.get(BlockID.DEEPSLATE_COPPER_ORE, meta);
    }
}