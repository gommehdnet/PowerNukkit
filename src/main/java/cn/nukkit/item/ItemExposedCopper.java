package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemExposedCopper extends Item {

    public ItemExposedCopper() {
        this(0, 1);
    }

    public ItemExposedCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemExposedCopper(Integer meta, int count) {
        super(ItemID.EXPOSED_COPPER, meta, count, "Exposed Copper");
        this.block = Block.get(BlockID.EXPOSED_COPPER, meta);
    }
}