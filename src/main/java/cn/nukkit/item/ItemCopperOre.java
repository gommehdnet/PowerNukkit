package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCopperOre extends Item {

    public ItemCopperOre() {
        this(0, 1);
    }

    public ItemCopperOre(Integer meta) {
        this(meta, 1);
    }

    public ItemCopperOre(Integer meta, int count) {
        super(ItemID.COPPER_ORE, meta, count, "Copper Ore");
        this.block = Block.get(BlockID.COPPER_ORE, meta);
    }
}