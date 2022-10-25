package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemClay extends Item {

    public ItemClay() {
        this(0, 1);
    }

    public ItemClay(Integer meta) {
        this(meta, 1);
    }

    public ItemClay(Integer meta, int count) {
        super(ItemID.CLAY, meta, count, "Clay");
        this.block = Block.get(BlockID.CLAY, meta);
    }
}