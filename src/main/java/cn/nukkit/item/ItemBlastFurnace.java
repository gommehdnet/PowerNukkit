package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlastFurnace extends Item {

    public ItemBlastFurnace() {
        this(0, 1);
    }

    public ItemBlastFurnace(Integer meta) {
        this(meta, 1);
    }

    public ItemBlastFurnace(Integer meta, int count) {
        super(ItemID.BLAST_FURNACE, meta, count, "Blast Furnace");
        this.block = Block.get(BlockID.BLAST_FURNACE, meta);
    }
}