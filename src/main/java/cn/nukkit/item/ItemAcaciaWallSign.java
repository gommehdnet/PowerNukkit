package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaWallSign extends Item {

    public ItemAcaciaWallSign() {
        this(0, 1);
    }

    public ItemAcaciaWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaWallSign(Integer meta, int count) {
        super(ItemID.ACACIA_WALL_SIGN, meta, count, "Acacia Wall Sign");
        this.block = Block.get(BlockID.ACACIA_WALL_SIGN, meta);
    }
}