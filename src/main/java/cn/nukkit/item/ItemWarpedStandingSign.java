package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedStandingSign extends Item {

    public ItemWarpedStandingSign() {
        this(0, 1);
    }

    public ItemWarpedStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedStandingSign(Integer meta, int count) {
        super(ItemID.WARPED_STANDING_SIGN, meta, count, "Warped Standing Sign");
        this.block = Block.get(BlockID.WARPED_STANDING_SIGN, meta);
    }
}