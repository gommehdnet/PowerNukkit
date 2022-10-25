package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCobbledDeepslateDoubleSlab extends Item {

    public ItemCobbledDeepslateDoubleSlab() {
        this(0, 1);
    }

    public ItemCobbledDeepslateDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemCobbledDeepslateDoubleSlab(Integer meta, int count) {
        super(ItemID.COBBLED_DEEPSLATE_DOUBLE_SLAB, meta, count, "Cobbled Deepslate Double Slab");
        this.block = Block.get(BlockID.COBBLED_DEEPSLATE_DOUBLE_SLAB, meta);
    }
}