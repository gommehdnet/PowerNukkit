package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemIronOre extends Item {

    public ItemIronOre() {
        this(0, 1);
    }

    public ItemIronOre(Integer meta) {
        this(meta, 1);
    }

    public ItemIronOre(Integer meta, int count) {
        super(ItemID.IRON_ORE, meta, count, "Iron Ore");
        this.block = Block.get(BlockID.IRON_ORE, meta);
    }
}