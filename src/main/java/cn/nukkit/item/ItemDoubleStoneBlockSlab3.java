package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDoubleStoneBlockSlab3 extends Item {

    public ItemDoubleStoneBlockSlab3() {
        this(0, 1);
    }

    public ItemDoubleStoneBlockSlab3(Integer meta) {
        this(meta, 1);
    }

    public ItemDoubleStoneBlockSlab3(Integer meta, int count) {
        super(ItemID.DOUBLE_STONE_BLOCK_SLAB3, meta, count, "Double Stone Block Slab3");
        this.block = Block.get(BlockID.DOUBLE_STONE_BLOCK_SLAB3, meta);
    }
}