package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGraniteStairs extends Item {

    public ItemGraniteStairs() {
        this(0, 1);
    }

    public ItemGraniteStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemGraniteStairs(Integer meta, int count) {
        super(ItemID.GRANITE_STAIRS, meta, count, "Granite Stairs");
        this.block = Block.get(BlockID.GRANITE_STAIRS, meta);
    }
}