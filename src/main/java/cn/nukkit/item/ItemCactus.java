package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCactus extends Item {

    public ItemCactus() {
        this(0, 1);
    }

    public ItemCactus(Integer meta) {
        this(meta, 1);
    }

    public ItemCactus(Integer meta, int count) {
        super(ItemID.CACTUS, meta, count, "Cactus");
        this.block = Block.get(BlockID.CACTUS, meta);
    }
}