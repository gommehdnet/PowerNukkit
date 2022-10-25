package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEmeraldOre extends Item {

    public ItemEmeraldOre() {
        this(0, 1);
    }

    public ItemEmeraldOre(Integer meta) {
        this(meta, 1);
    }

    public ItemEmeraldOre(Integer meta, int count) {
        super(ItemID.EMERALD_ORE, meta, count, "Emerald Ore");
        this.block = Block.get(BlockID.EMERALD_ORE, meta);
    }
}