package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmoothBasalt extends Item {

    public ItemSmoothBasalt() {
        this(0, 1);
    }

    public ItemSmoothBasalt(Integer meta) {
        this(meta, 1);
    }

    public ItemSmoothBasalt(Integer meta, int count) {
        super(ItemID.SMOOTH_BASALT, meta, count, "Smooth Basalt");
        this.block = Block.get(BlockID.SMOOTH_BASALT, meta);
    }
}