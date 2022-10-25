package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonWallSign extends Item {

    public ItemCrimsonWallSign() {
        this(0, 1);
    }

    public ItemCrimsonWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonWallSign(Integer meta, int count) {
        super(ItemID.CRIMSON_WALL_SIGN, meta, count, "Crimson Wall Sign");
        this.block = Block.get(BlockID.CRIMSON_WALL_SIGN, meta);
    }
}