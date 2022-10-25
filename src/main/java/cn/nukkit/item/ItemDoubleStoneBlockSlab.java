package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDoubleStoneBlockSlab extends Item {

    public ItemDoubleStoneBlockSlab() {
        this(0, 1);
    }

    public ItemDoubleStoneBlockSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemDoubleStoneBlockSlab(Integer meta, int count) {
        super(ItemID.DOUBLE_STONE_BLOCK_SLAB, meta, count, "Double Stone Block Slab");
        this.block = Block.get(BlockID.DOUBLE_STONE_BLOCK_SLAB, meta);
    }
}