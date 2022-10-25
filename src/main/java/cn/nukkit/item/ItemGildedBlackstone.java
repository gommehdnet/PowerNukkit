package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGildedBlackstone extends Item {

    public ItemGildedBlackstone() {
        this(0, 1);
    }

    public ItemGildedBlackstone(Integer meta) {
        this(meta, 1);
    }

    public ItemGildedBlackstone(Integer meta, int count) {
        super(ItemID.GILDED_BLACKSTONE, meta, count, "Gilded Blackstone");
        this.block = Block.get(BlockID.GILDED_BLACKSTONE, meta);
    }
}