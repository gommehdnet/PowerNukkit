package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemActivatorRail extends Item {

    public ItemActivatorRail() {
        this(0, 1);
    }

    public ItemActivatorRail(Integer meta) {
        this(meta, 1);
    }

    public ItemActivatorRail(Integer meta, int count) {
        super(ItemID.ACTIVATOR_RAIL, meta, count, "Activator Rail");
        this.block = Block.get(BlockID.ACTIVATOR_RAIL, meta);
    }
}