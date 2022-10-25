package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAir extends Item {

    public ItemAir() {
        this(0, 1);
    }

    public ItemAir(Integer meta) {
        this(meta, 1);
    }

    public ItemAir(Integer meta, int count) {
        super(ItemID.AIR, meta, count, "Air");
        this.block = Block.get(BlockID.AIR, meta);
    }
}