package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedCopper extends Item {

    public ItemWaxedCopper() {
        this(0, 1);
    }

    public ItemWaxedCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedCopper(Integer meta, int count) {
        super(ItemID.WAXED_COPPER, meta, count, "Waxed Copper");
        this.block = Block.get(BlockID.WAXED_COPPER, meta);
    }
}