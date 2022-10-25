package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDoubleStoneBlockSlab2 extends Item {

    public ItemDoubleStoneBlockSlab2() {
        this(0, 1);
    }

    public ItemDoubleStoneBlockSlab2(Integer meta) {
        this(meta, 1);
    }

    public ItemDoubleStoneBlockSlab2(Integer meta, int count) {
        super(ItemID.DOUBLE_STONE_BLOCK_SLAB2, meta, count, "Double Stone Block Slab2");
        this.block = Block.get(BlockID.DOUBLE_STONE_BLOCK_SLAB2, meta);
    }
}