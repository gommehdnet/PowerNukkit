package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemIce extends Item {

    public ItemIce() {
        this(0, 1);
    }

    public ItemIce(Integer meta) {
        this(meta, 1);
    }

    public ItemIce(Integer meta, int count) {
        super(ItemID.ICE, meta, count, "Ice");
        this.block = Block.get(BlockID.ICE, meta);
    }
}