package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSand extends Item {

    public ItemSand() {
        this(0, 1);
    }

    public ItemSand(Integer meta) {
        this(meta, 1);
    }

    public ItemSand(Integer meta, int count) {
        super(ItemID.SAND, meta, count, "Sand");
        this.block = Block.get(BlockID.SAND, meta);
    }
}