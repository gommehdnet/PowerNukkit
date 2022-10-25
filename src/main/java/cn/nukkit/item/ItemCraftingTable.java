package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCraftingTable extends Item {

    public ItemCraftingTable() {
        this(0, 1);
    }

    public ItemCraftingTable(Integer meta) {
        this(meta, 1);
    }

    public ItemCraftingTable(Integer meta, int count) {
        super(ItemID.CRAFTING_TABLE, meta, count, "Crafting Table");
        this.block = Block.get(BlockID.CRAFTING_TABLE, meta);
    }
}