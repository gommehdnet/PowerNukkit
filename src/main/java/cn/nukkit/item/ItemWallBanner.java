package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWallBanner extends Item {

    public ItemWallBanner() {
        this(0, 1);
    }

    public ItemWallBanner(Integer meta) {
        this(meta, 1);
    }

    public ItemWallBanner(Integer meta, int count) {
        super(ItemID.WALL_BANNER, meta, count, "Wall Banner");
        this.block = Block.get(BlockID.WALL_BANNER, meta);
    }
}