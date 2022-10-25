package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChemistryTable extends Item {

    public ItemChemistryTable() {
        this(0, 1);
    }

    public ItemChemistryTable(Integer meta) {
        this(meta, 1);
    }

    public ItemChemistryTable(Integer meta, int count) {
        super(ItemID.CHEMISTRY_TABLE, meta, count, "Chemistry Table");
        this.block = Block.get(BlockID.CHEMISTRY_TABLE, meta);
    }
}