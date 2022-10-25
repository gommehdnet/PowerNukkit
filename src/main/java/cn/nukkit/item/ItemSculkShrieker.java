package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSculkShrieker extends Item {

    public ItemSculkShrieker() {
        this(0, 1);
    }

    public ItemSculkShrieker(Integer meta) {
        this(meta, 1);
    }

    public ItemSculkShrieker(Integer meta, int count) {
        super(ItemID.SCULK_SHRIEKER, meta, count, "Sculk Shrieker");
        this.block = Block.get(BlockID.SCULK_SHRIEKER, meta);
    }
}