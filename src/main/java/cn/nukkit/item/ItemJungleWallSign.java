package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJungleWallSign extends Item {

    public ItemJungleWallSign() {
        this(0, 1);
    }

    public ItemJungleWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleWallSign(Integer meta, int count) {
        super(ItemID.JUNGLE_WALL_SIGN, meta, count, "Jungle Wall Sign");
        this.block = Block.get(BlockID.JUNGLE_WALL_SIGN, meta);
    }
}