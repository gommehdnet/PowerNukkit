package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLitBlastFurnace extends Item {

    public ItemLitBlastFurnace() {
        this(0, 1);
    }

    public ItemLitBlastFurnace(Integer meta) {
        this(meta, 1);
    }

    public ItemLitBlastFurnace(Integer meta, int count) {
        super(ItemID.LIT_BLAST_FURNACE, meta, count, "Lit Blast Furnace");
        this.block = Block.get(BlockID.LIT_BLAST_FURNACE, meta);
    }
}