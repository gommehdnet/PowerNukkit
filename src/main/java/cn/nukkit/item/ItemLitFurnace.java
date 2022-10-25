package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLitFurnace extends Item {

    public ItemLitFurnace() {
        this(0, 1);
    }

    public ItemLitFurnace(Integer meta) {
        this(meta, 1);
    }

    public ItemLitFurnace(Integer meta, int count) {
        super(ItemID.LIT_FURNACE, meta, count, "Lit Furnace");
        this.block = Block.get(BlockID.LIT_FURNACE, meta);
    }
}