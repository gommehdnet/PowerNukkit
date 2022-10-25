package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackstoneWall extends Item {

    public ItemBlackstoneWall() {
        this(0, 1);
    }

    public ItemBlackstoneWall(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackstoneWall(Integer meta, int count) {
        super(ItemID.BLACKSTONE_WALL, meta, count, "Blackstone Wall");
        this.block = Block.get(BlockID.BLACKSTONE_WALL, meta);
    }
}