package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAndesiteStairs extends Item {

    public ItemAndesiteStairs() {
        this(0, 1);
    }

    public ItemAndesiteStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemAndesiteStairs(Integer meta, int count) {
        super(ItemID.ANDESITE_STAIRS, meta, count, "Andesite Stairs");
        this.block = Block.get(BlockID.ANDESITE_STAIRS, meta);
    }
}