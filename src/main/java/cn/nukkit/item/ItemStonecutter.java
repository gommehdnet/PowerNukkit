package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStonecutter extends Item {

    public ItemStonecutter() {
        this(0, 1);
    }

    public ItemStonecutter(Integer meta) {
        this(meta, 1);
    }

    public ItemStonecutter(Integer meta, int count) {
        super(ItemID.STONECUTTER, meta, count, "Stonecutter");
        this.block = Block.get(BlockID.STONECUTTER, meta);
    }
}