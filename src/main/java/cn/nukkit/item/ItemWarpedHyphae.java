package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedHyphae extends Item {

    public ItemWarpedHyphae() {
        this(0, 1);
    }

    public ItemWarpedHyphae(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedHyphae(Integer meta, int count) {
        super(ItemID.WARPED_HYPHAE, meta, count, "Warped Hyphae");
        this.block = Block.get(BlockID.WARPED_HYPHAE, meta);
    }
}