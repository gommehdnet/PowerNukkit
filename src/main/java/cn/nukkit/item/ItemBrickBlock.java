package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBrickBlock extends Item {

    public ItemBrickBlock() {
        this(0, 1);
    }

    public ItemBrickBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemBrickBlock(Integer meta, int count) {
        super(ItemID.BRICK_BLOCK, meta, count, "Brick Block");
        this.block = Block.get(BlockID.BRICK_BLOCK, meta);
    }
}