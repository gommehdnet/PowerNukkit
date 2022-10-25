package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChiseledPolishedBlackstone extends Item {

    public ItemChiseledPolishedBlackstone() {
        this(0, 1);
    }

    public ItemChiseledPolishedBlackstone(Integer meta) {
        this(meta, 1);
    }

    public ItemChiseledPolishedBlackstone(Integer meta, int count) {
        super(ItemID.CHISELED_POLISHED_BLACKSTONE, meta, count, "Chiseled Polished Blackstone");
        this.block = Block.get(BlockID.CHISELED_POLISHED_BLACKSTONE, meta);
    }
}