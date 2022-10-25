package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCarpet extends Item {

    public ItemCarpet() {
        this(0, 1);
    }

    public ItemCarpet(Integer meta) {
        this(meta, 1);
    }

    public ItemCarpet(Integer meta, int count) {
        super(ItemID.CARPET, meta, count, "Carpet");
        this.block = Block.get(BlockID.CARPET, meta);
    }
}