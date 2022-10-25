package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDoubleStoneBlockSlab4 extends Item {

    public ItemDoubleStoneBlockSlab4() {
        this(0, 1);
    }

    public ItemDoubleStoneBlockSlab4(Integer meta) {
        this(meta, 1);
    }

    public ItemDoubleStoneBlockSlab4(Integer meta, int count) {
        super(ItemID.DOUBLE_STONE_BLOCK_SLAB4, meta, count, "Double Stone Block Slab4");
        this.block = Block.get(BlockID.DOUBLE_STONE_BLOCK_SLAB4, meta);
    }
}