package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmithingTable extends Item {

    public ItemSmithingTable() {
        this(0, 1);
    }

    public ItemSmithingTable(Integer meta) {
        this(meta, 1);
    }

    public ItemSmithingTable(Integer meta, int count) {
        super(ItemID.SMITHING_TABLE, meta, count, "Smithing Table");
        this.block = Block.get(BlockID.SMITHING_TABLE, meta);
    }
}