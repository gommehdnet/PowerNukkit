package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPrismarine extends Item {

    public ItemPrismarine() {
        this(0, 1);
    }

    public ItemPrismarine(Integer meta) {
        this(meta, 1);
    }

    public ItemPrismarine(Integer meta, int count) {
        super(ItemID.PRISMARINE, meta, count, "Prismarine");
        this.block = Block.get(BlockID.PRISMARINE, meta);
    }
}