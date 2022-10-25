package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateEmeraldOre extends Item {

    public ItemDeepslateEmeraldOre() {
        this(0, 1);
    }

    public ItemDeepslateEmeraldOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateEmeraldOre(Integer meta, int count) {
        super(ItemID.DEEPSLATE_EMERALD_ORE, meta, count, "Deepslate Emerald Ore");
        this.block = Block.get(BlockID.DEEPSLATE_EMERALD_ORE, meta);
    }
}