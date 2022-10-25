package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBorderBlock extends Item {

    public ItemBorderBlock() {
        this(0, 1);
    }

    public ItemBorderBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemBorderBlock(Integer meta, int count) {
        super(ItemID.BORDER_BLOCK, meta, count, "Border Block");
        this.block = Block.get(BlockID.BORDER_BLOCK, meta);
    }
}