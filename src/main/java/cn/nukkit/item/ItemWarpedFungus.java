package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedFungus extends Item {

    public ItemWarpedFungus() {
        this(0, 1);
    }

    public ItemWarpedFungus(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedFungus(Integer meta, int count) {
        super(ItemID.WARPED_FUNGUS, meta, count, "Warped Fungus");
        this.block = Block.get(BlockID.WARPED_FUNGUS, meta);
    }
}