package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedExposedCopper extends Item {

    public ItemWaxedExposedCopper() {
        this(0, 1);
    }

    public ItemWaxedExposedCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedExposedCopper(Integer meta, int count) {
        super(ItemID.WAXED_EXPOSED_COPPER, meta, count, "Waxed Exposed Copper");
        this.block = Block.get(BlockID.WAXED_EXPOSED_COPPER, meta);
    }
}