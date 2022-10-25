package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemConduit extends Item {

    public ItemConduit() {
        this(0, 1);
    }

    public ItemConduit(Integer meta) {
        this(meta, 1);
    }

    public ItemConduit(Integer meta, int count) {
        super(ItemID.CONDUIT, meta, count, "Conduit");
        this.block = Block.get(BlockID.CONDUIT, meta);
    }
}