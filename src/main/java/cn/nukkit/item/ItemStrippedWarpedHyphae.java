package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedWarpedHyphae extends Item {

    public ItemStrippedWarpedHyphae() {
        this(0, 1);
    }

    public ItemStrippedWarpedHyphae(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedWarpedHyphae(Integer meta, int count) {
        super(ItemID.STRIPPED_WARPED_HYPHAE, meta, count, "Stripped Warped Hyphae");
        this.block = Block.get(BlockID.STRIPPED_WARPED_HYPHAE, meta);
    }
}