package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGoldenRail extends Item {

    public ItemGoldenRail() {
        this(0, 1);
    }

    public ItemGoldenRail(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldenRail(Integer meta, int count) {
        super(ItemID.GOLDEN_RAIL, meta, count, "Golden Rail");
        this.block = Block.get(BlockID.GOLDEN_RAIL, meta);
    }
}