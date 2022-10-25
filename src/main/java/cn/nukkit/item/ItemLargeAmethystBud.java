package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLargeAmethystBud extends Item {

    public ItemLargeAmethystBud() {
        this(0, 1);
    }

    public ItemLargeAmethystBud(Integer meta) {
        this(meta, 1);
    }

    public ItemLargeAmethystBud(Integer meta, int count) {
        super(ItemID.LARGE_AMETHYST_BUD, meta, count, "Large Amethyst Bud");
        this.block = Block.get(BlockID.LARGE_AMETHYST_BUD, meta);
    }
}