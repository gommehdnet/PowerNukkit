package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJungleStairs extends Item {

    public ItemJungleStairs() {
        this(0, 1);
    }

    public ItemJungleStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleStairs(Integer meta, int count) {
        super(ItemID.JUNGLE_STAIRS, meta, count, "Jungle Stairs");
        this.block = Block.get(BlockID.JUNGLE_STAIRS, meta);
    }
}