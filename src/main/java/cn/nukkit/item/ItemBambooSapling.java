package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBambooSapling extends Item {

    public ItemBambooSapling() {
        this(0, 1);
    }

    public ItemBambooSapling(Integer meta) {
        this(meta, 1);
    }

    public ItemBambooSapling(Integer meta, int count) {
        super(ItemID.BAMBOO_SAPLING, meta, count, "Bamboo Sapling");
        this.block = Block.get(BlockID.BAMBOO_SAPLING, meta);
    }
}