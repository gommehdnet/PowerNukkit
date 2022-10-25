package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStandingBanner extends Item {

    public ItemStandingBanner() {
        this(0, 1);
    }

    public ItemStandingBanner(Integer meta) {
        this(meta, 1);
    }

    public ItemStandingBanner(Integer meta, int count) {
        super(ItemID.STANDING_BANNER, meta, count, "Standing Banner");
        this.block = Block.get(BlockID.STANDING_BANNER, meta);
    }
}