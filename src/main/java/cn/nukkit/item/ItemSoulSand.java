package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSoulSand extends Item {

    public ItemSoulSand() {
        this(0, 1);
    }

    public ItemSoulSand(Integer meta) {
        this(meta, 1);
    }

    public ItemSoulSand(Integer meta, int count) {
        super(ItemID.SOUL_SAND, meta, count, "Soul Sand");
        this.block = Block.get(BlockID.SOUL_SAND, meta);
    }
}