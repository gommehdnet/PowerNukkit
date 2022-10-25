package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWallSign extends Item {

    public ItemWallSign() {
        this(0, 1);
    }

    public ItemWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemWallSign(Integer meta, int count) {
        super(ItemID.WALL_SIGN, meta, count, "Wall Sign");
        this.block = Block.get(BlockID.WALL_SIGN, meta);
    }
}