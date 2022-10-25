package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstone extends Item {

    public ItemPolishedBlackstone() {
        this(0, 1);
    }

    public ItemPolishedBlackstone(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstone(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE, meta, count, "Polished Blackstone");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE, meta);
    }
}