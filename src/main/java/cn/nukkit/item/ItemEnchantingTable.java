package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEnchantingTable extends Item {

    public ItemEnchantingTable() {
        this(0, 1);
    }

    public ItemEnchantingTable(Integer meta) {
        this(meta, 1);
    }

    public ItemEnchantingTable(Integer meta, int count) {
        super(ItemID.ENCHANTING_TABLE, meta, count, "Enchanting Table");
        this.block = Block.get(BlockID.ENCHANTING_TABLE, meta);
    }
}