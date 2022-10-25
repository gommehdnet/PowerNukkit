package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFrostedIce extends Item {

    public ItemFrostedIce() {
        this(0, 1);
    }

    public ItemFrostedIce(Integer meta) {
        this(meta, 1);
    }

    public ItemFrostedIce(Integer meta, int count) {
        super(ItemID.FROSTED_ICE, meta, count, "Frosted Ice");
        this.block = Block.get(BlockID.FROSTED_ICE, meta);
    }
}