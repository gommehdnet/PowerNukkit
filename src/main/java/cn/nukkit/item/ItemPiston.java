package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPiston extends Item {

    public ItemPiston() {
        this(0, 1);
    }

    public ItemPiston(Integer meta) {
        this(meta, 1);
    }

    public ItemPiston(Integer meta, int count) {
        super(ItemID.PISTON, meta, count, "Piston");
        this.block = Block.get(BlockID.PISTON, meta);
    }
}