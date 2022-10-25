package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSculkVein extends Item {

    public ItemSculkVein() {
        this(0, 1);
    }

    public ItemSculkVein(Integer meta) {
        this(meta, 1);
    }

    public ItemSculkVein(Integer meta, int count) {
        super(ItemID.SCULK_VEIN, meta, count, "Sculk Vein");
        this.block = Block.get(BlockID.SCULK_VEIN, meta);
    }
}