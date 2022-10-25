package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedSandstone extends Item {

    public ItemRedSandstone() {
        this(0, 1);
    }

    public ItemRedSandstone(Integer meta) {
        this(meta, 1);
    }

    public ItemRedSandstone(Integer meta, int count) {
        super(ItemID.RED_SANDSTONE, meta, count, "Red Sandstone");
        this.block = Block.get(BlockID.RED_SANDSTONE, meta);
    }
}