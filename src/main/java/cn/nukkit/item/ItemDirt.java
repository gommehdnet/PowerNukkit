package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDirt extends Item {

    public ItemDirt() {
        this(0, 1);
    }

    public ItemDirt(Integer meta) {
        this(meta, 1);
    }

    public ItemDirt(Integer meta, int count) {
        super(ItemID.DIRT, meta, count, "Dirt");
        this.block = Block.get(BlockID.DIRT, meta);
    }
}