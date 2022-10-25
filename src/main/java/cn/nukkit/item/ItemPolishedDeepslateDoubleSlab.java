package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedDeepslateDoubleSlab extends Item {

    public ItemPolishedDeepslateDoubleSlab() {
        this(0, 1);
    }

    public ItemPolishedDeepslateDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedDeepslateDoubleSlab(Integer meta, int count) {
        super(ItemID.POLISHED_DEEPSLATE_DOUBLE_SLAB, meta, count, "Polished Deepslate Double Slab");
        this.block = Block.get(BlockID.POLISHED_DEEPSLATE_DOUBLE_SLAB, meta);
    }
}