package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCobblestone extends Item {

    public ItemCobblestone() {
        this(0, 1);
    }

    public ItemCobblestone(Integer meta) {
        this(meta, 1);
    }

    public ItemCobblestone(Integer meta, int count) {
        super(ItemID.COBBLESTONE, meta, count, "Cobblestone");
        this.block = Block.get(BlockID.COBBLESTONE, meta);
    }
}