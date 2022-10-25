package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPointedDripstone extends Item {

    public ItemPointedDripstone() {
        this(0, 1);
    }

    public ItemPointedDripstone(Integer meta) {
        this(meta, 1);
    }

    public ItemPointedDripstone(Integer meta, int count) {
        super(ItemID.POINTED_DRIPSTONE, meta, count, "Pointed Dripstone");
        this.block = Block.get(BlockID.POINTED_DRIPSTONE, meta);
    }
}