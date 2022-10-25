package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveWallSign extends Item {

    public ItemMangroveWallSign() {
        this(0, 1);
    }

    public ItemMangroveWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveWallSign(Integer meta, int count) {
        super(ItemID.MANGROVE_WALL_SIGN, meta, count, "Mangrove Wall Sign");
        this.block = Block.get(BlockID.MANGROVE_WALL_SIGN, meta);
    }
}