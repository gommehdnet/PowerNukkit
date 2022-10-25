package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStoneBlockSlab3 extends Item {

    public ItemStoneBlockSlab3() {
        this(0, 1);
    }

    public ItemStoneBlockSlab3(Integer meta) {
        this(meta, 1);
    }

    public ItemStoneBlockSlab3(Integer meta, int count) {
        super(ItemID.STONE_BLOCK_SLAB3, meta, count, "Stone Block Slab3");
        this.block = Block.get(BlockID.STONE_BLOCK_SLAB3, meta);
    }
}