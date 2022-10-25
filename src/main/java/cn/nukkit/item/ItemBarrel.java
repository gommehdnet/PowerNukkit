package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBarrel extends Item {

    public ItemBarrel() {
        this(0, 1);
    }

    public ItemBarrel(Integer meta) {
        this(meta, 1);
    }

    public ItemBarrel(Integer meta, int count) {
        super(ItemID.BARREL, meta, count, "Barrel");
        this.block = Block.get(BlockID.BARREL, meta);
    }
}