package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateRedstoneOre extends Item {

    public ItemDeepslateRedstoneOre() {
        this(0, 1);
    }

    public ItemDeepslateRedstoneOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateRedstoneOre(Integer meta, int count) {
        super(ItemID.DEEPSLATE_REDSTONE_ORE, meta, count, "Deepslate Redstone Ore");
        this.block = Block.get(BlockID.DEEPSLATE_REDSTONE_ORE, meta);
    }
}