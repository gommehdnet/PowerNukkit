package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStonebrick extends Item {

    public ItemStonebrick() {
        this(0, 1);
    }

    public ItemStonebrick(Integer meta) {
        this(meta, 1);
    }

    public ItemStonebrick(Integer meta, int count) {
        super(ItemID.STONEBRICK, meta, count, "Stonebrick");
        this.block = Block.get(BlockID.STONEBRICK, meta);
    }
}