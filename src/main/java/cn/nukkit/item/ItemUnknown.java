package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemUnknown extends Item {

    public ItemUnknown() {
        this(0, 1);
    }

    public ItemUnknown(Integer meta) {
        this(meta, 1);
    }

    public ItemUnknown(Integer meta, int count) {
        super(ItemID.UNKNOWN, meta, count, "Unknown");
        this.block = Block.get(BlockID.UNKNOWN, meta);
    }
}