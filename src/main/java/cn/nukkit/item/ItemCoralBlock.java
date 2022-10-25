package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoralBlock extends Item {

    public ItemCoralBlock() {
        this(0, 1);
    }

    public ItemCoralBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemCoralBlock(Integer meta, int count) {
        super(ItemID.CORAL_BLOCK, meta, count, "Coral Block");
        this.block = Block.get(BlockID.CORAL_BLOCK, meta);
    }
}