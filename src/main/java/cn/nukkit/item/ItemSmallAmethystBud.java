package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmallAmethystBud extends Item {

    public ItemSmallAmethystBud() {
        this(0, 1);
    }

    public ItemSmallAmethystBud(Integer meta) {
        this(meta, 1);
    }

    public ItemSmallAmethystBud(Integer meta, int count) {
        super(ItemID.SMALL_AMETHYST_BUD, meta, count, "Small Amethyst Bud");
        this.block = Block.get(BlockID.SMALL_AMETHYST_BUD, meta);
    }
}