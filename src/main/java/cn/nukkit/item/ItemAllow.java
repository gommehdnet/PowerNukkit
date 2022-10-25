package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAllow extends Item {

    public ItemAllow() {
        this(0, 1);
    }

    public ItemAllow(Integer meta) {
        this(meta, 1);
    }

    public ItemAllow(Integer meta, int count) {
        super(ItemID.ALLOW, meta, count, "Allow");
        this.block = Block.get(BlockID.ALLOW, meta);
    }
}