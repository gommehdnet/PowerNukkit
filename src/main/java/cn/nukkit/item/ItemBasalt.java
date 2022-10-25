package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBasalt extends Item {

    public ItemBasalt() {
        this(0, 1);
    }

    public ItemBasalt(Integer meta) {
        this(meta, 1);
    }

    public ItemBasalt(Integer meta, int count) {
        super(ItemID.BASALT, meta, count, "Basalt");
        this.block = Block.get(BlockID.BASALT, meta);
    }
}