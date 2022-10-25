package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmallDripleafBlock extends Item {

    public ItemSmallDripleafBlock() {
        this(0, 1);
    }

    public ItemSmallDripleafBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemSmallDripleafBlock(Integer meta, int count) {
        super(ItemID.SMALL_DRIPLEAF_BLOCK, meta, count, "Small Dripleaf Block");
        this.block = Block.get(BlockID.SMALL_DRIPLEAF_BLOCK, meta);
    }
}