package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkoakWallSign extends Item {

    public ItemDarkoakWallSign() {
        this(0, 1);
    }

    public ItemDarkoakWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkoakWallSign(Integer meta, int count) {
        super(ItemID.DARKOAK_WALL_SIGN, meta, count, "Darkoak Wall Sign");
        this.block = Block.get(BlockID.DARKOAK_WALL_SIGN, meta);
    }
}