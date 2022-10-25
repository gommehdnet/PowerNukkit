package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSnow extends Item {

    public ItemSnow() {
        this(0, 1);
    }

    public ItemSnow(Integer meta) {
        this(meta, 1);
    }

    public ItemSnow(Integer meta, int count) {
        super(ItemID.SNOW, meta, count, "Snow");
        this.block = Block.get(BlockID.SNOW, meta);
    }
}