package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSapling extends Item {

    public ItemSapling() {
        this(0, 1);
    }

    public ItemSapling(Integer meta) {
        this(meta, 1);
    }

    public ItemSapling(Integer meta, int count) {
        super(ItemID.SAPLING, meta, count, "Sapling");
        this.block = Block.get(BlockID.SAPLING, meta);
    }
}