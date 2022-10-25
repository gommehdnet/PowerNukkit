package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFurnace extends Item {

    public ItemFurnace() {
        this(0, 1);
    }

    public ItemFurnace(Integer meta) {
        this(meta, 1);
    }

    public ItemFurnace(Integer meta, int count) {
        super(ItemID.FURNACE, meta, count, "Furnace");
        this.block = Block.get(BlockID.FURNACE, meta);
    }
}