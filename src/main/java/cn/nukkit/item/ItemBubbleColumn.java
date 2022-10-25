package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBubbleColumn extends Item {

    public ItemBubbleColumn() {
        this(0, 1);
    }

    public ItemBubbleColumn(Integer meta) {
        this(meta, 1);
    }

    public ItemBubbleColumn(Integer meta, int count) {
        super(ItemID.BUBBLE_COLUMN, meta, count, "Bubble Column");
        this.block = Block.get(BlockID.BUBBLE_COLUMN, meta);
    }
}