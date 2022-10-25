package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemReserved6 extends Item {

    public ItemReserved6() {
        this(0, 1);
    }

    public ItemReserved6(Integer meta) {
        this(meta, 1);
    }

    public ItemReserved6(Integer meta, int count) {
        super(ItemID.RESERVED6, meta, count, "Reserved6");
        this.block = Block.get(BlockID.RESERVED6, meta);
    }
}