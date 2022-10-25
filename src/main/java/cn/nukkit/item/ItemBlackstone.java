package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackstone extends Item {

    public ItemBlackstone() {
        this(0, 1);
    }

    public ItemBlackstone(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackstone(Integer meta, int count) {
        super(ItemID.BLACKSTONE, meta, count, "Blackstone");
        this.block = Block.get(BlockID.BLACKSTONE, meta);
    }
}