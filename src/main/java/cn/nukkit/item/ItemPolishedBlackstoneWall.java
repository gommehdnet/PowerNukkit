package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneWall extends Item {

    public ItemPolishedBlackstoneWall() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneWall(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneWall(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_WALL, meta, count, "Polished Blackstone Wall");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_WALL, meta);
    }
}