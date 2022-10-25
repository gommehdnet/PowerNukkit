package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMossyCobblestone extends Item {

    public ItemMossyCobblestone() {
        this(0, 1);
    }

    public ItemMossyCobblestone(Integer meta) {
        this(meta, 1);
    }

    public ItemMossyCobblestone(Integer meta, int count) {
        super(ItemID.MOSSY_COBBLESTONE, meta, count, "Mossy Cobblestone");
        this.block = Block.get(BlockID.MOSSY_COBBLESTONE, meta);
    }
}