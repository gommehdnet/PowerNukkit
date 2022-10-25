package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMossyCobblestoneStairs extends Item {

    public ItemMossyCobblestoneStairs() {
        this(0, 1);
    }

    public ItemMossyCobblestoneStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemMossyCobblestoneStairs(Integer meta, int count) {
        super(ItemID.MOSSY_COBBLESTONE_STAIRS, meta, count, "Mossy Cobblestone Stairs");
        this.block = Block.get(BlockID.MOSSY_COBBLESTONE_STAIRS, meta);
    }
}