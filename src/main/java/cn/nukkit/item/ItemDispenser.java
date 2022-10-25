package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDispenser extends Item {

    public ItemDispenser() {
        this(0, 1);
    }

    public ItemDispenser(Integer meta) {
        this(meta, 1);
    }

    public ItemDispenser(Integer meta, int count) {
        super(ItemID.DISPENSER, meta, count, "Dispenser");
        this.block = Block.get(BlockID.DISPENSER, meta);
    }
}