package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCartographyTable extends Item {

    public ItemCartographyTable() {
        this(0, 1);
    }

    public ItemCartographyTable(Integer meta) {
        this(meta, 1);
    }

    public ItemCartographyTable(Integer meta, int count) {
        super(ItemID.CARTOGRAPHY_TABLE, meta, count, "Cartography Table");
        this.block = Block.get(BlockID.CARTOGRAPHY_TABLE, meta);
    }
}