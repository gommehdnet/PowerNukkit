package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchWallSign extends Item {

    public ItemBirchWallSign() {
        this(0, 1);
    }

    public ItemBirchWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchWallSign(Integer meta, int count) {
        super(ItemID.BIRCH_WALL_SIGN, meta, count, "Birch Wall Sign");
        this.block = Block.get(BlockID.BIRCH_WALL_SIGN, meta);
    }
}