package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFletchingTable extends Item {

    public ItemFletchingTable() {
        this(0, 1);
    }

    public ItemFletchingTable(Integer meta) {
        this(meta, 1);
    }

    public ItemFletchingTable(Integer meta, int count) {
        super(ItemID.FLETCHING_TABLE, meta, count, "Fletching Table");
        this.block = Block.get(BlockID.FLETCHING_TABLE, meta);
    }
}