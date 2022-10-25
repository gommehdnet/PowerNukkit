package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMovingBlock extends Item {

    public ItemMovingBlock() {
        this(0, 1);
    }

    public ItemMovingBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemMovingBlock(Integer meta, int count) {
        super(ItemID.MOVING_BLOCK, meta, count, "Moving Block");
        this.block = Block.get(BlockID.MOVING_BLOCK, meta);
    }
}