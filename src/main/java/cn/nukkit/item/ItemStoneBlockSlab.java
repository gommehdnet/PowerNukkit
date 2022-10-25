package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStoneBlockSlab extends Item {

    public ItemStoneBlockSlab() {
        this(0, 1);
    }

    public ItemStoneBlockSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemStoneBlockSlab(Integer meta, int count) {
        super(ItemID.STONE_BLOCK_SLAB, meta, count, "Stone Block Slab");
        this.block = Block.get(BlockID.STONE_BLOCK_SLAB, meta);
    }
}