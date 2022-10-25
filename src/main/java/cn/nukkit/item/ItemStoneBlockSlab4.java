package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStoneBlockSlab4 extends Item {

    public ItemStoneBlockSlab4() {
        this(0, 1);
    }

    public ItemStoneBlockSlab4(Integer meta) {
        this(meta, 1);
    }

    public ItemStoneBlockSlab4(Integer meta, int count) {
        super(ItemID.STONE_BLOCK_SLAB4, meta, count, "Stone Block Slab4");
        this.block = Block.get(BlockID.STONE_BLOCK_SLAB4, meta);
    }
}