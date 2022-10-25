package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndRod extends Item {

    public ItemEndRod() {
        this(0, 1);
    }

    public ItemEndRod(Integer meta) {
        this(meta, 1);
    }

    public ItemEndRod(Integer meta, int count) {
        super(ItemID.END_ROD, meta, count, "End Rod");
        this.block = Block.get(BlockID.END_ROD, meta);
    }
}