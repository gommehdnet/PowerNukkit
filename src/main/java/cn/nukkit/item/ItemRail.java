package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRail extends Item {

    public ItemRail() {
        this(0, 1);
    }

    public ItemRail(Integer meta) {
        this(meta, 1);
    }

    public ItemRail(Integer meta, int count) {
        super(ItemID.RAIL, meta, count, "Rail");
        this.block = Block.get(BlockID.RAIL, meta);
    }
}