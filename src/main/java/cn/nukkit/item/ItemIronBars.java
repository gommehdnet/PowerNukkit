package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemIronBars extends Item {

    public ItemIronBars() {
        this(0, 1);
    }

    public ItemIronBars(Integer meta) {
        this(meta, 1);
    }

    public ItemIronBars(Integer meta, int count) {
        super(ItemID.IRON_BARS, meta, count, "Iron Bars");
        this.block = Block.get(BlockID.IRON_BARS, meta);
    }
}