package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedWallSign extends Item {

    public ItemWarpedWallSign() {
        this(0, 1);
    }

    public ItemWarpedWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedWallSign(Integer meta, int count) {
        super(ItemID.WARPED_WALL_SIGN, meta, count, "Warped Wall Sign");
        this.block = Block.get(BlockID.WARPED_WALL_SIGN, meta);
    }
}