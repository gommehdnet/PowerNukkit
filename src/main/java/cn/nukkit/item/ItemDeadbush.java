package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeadbush extends Item {

    public ItemDeadbush() {
        this(0, 1);
    }

    public ItemDeadbush(Integer meta) {
        this(meta, 1);
    }

    public ItemDeadbush(Integer meta, int count) {
        super(ItemID.DEADBUSH, meta, count, "Deadbush");
        this.block = Block.get(BlockID.DEADBUSH, meta);
    }
}