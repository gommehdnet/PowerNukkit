package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDiamondOre extends Item {

    public ItemDiamondOre() {
        this(0, 1);
    }

    public ItemDiamondOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondOre(Integer meta, int count) {
        super(ItemID.DIAMOND_ORE, meta, count, "Diamond Ore");
        this.block = Block.get(BlockID.DIAMOND_ORE, meta);
    }
}