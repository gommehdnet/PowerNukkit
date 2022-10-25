package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBasalt extends Item {

    public ItemPolishedBasalt() {
        this(0, 1);
    }

    public ItemPolishedBasalt(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBasalt(Integer meta, int count) {
        super(ItemID.POLISHED_BASALT, meta, count, "Polished Basalt");
        this.block = Block.get(BlockID.POLISHED_BASALT, meta);
    }
}