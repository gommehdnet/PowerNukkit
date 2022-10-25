package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBamboo extends Item {

    public ItemBamboo() {
        this(0, 1);
    }

    public ItemBamboo(Integer meta) {
        this(meta, 1);
    }

    public ItemBamboo(Integer meta, int count) {
        super(ItemID.BAMBOO, meta, count, "Bamboo");
        this.block = Block.get(BlockID.BAMBOO, meta);
    }
}