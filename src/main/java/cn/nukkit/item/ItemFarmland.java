package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFarmland extends Item {

    public ItemFarmland() {
        this(0, 1);
    }

    public ItemFarmland(Integer meta) {
        this(meta, 1);
    }

    public ItemFarmland(Integer meta, int count) {
        super(ItemID.FARMLAND, meta, count, "Farmland");
        this.block = Block.get(BlockID.FARMLAND, meta);
    }
}