package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLectern extends Item {

    public ItemLectern() {
        this(0, 1);
    }

    public ItemLectern(Integer meta) {
        this(meta, 1);
    }

    public ItemLectern(Integer meta, int count) {
        super(ItemID.LECTERN, meta, count, "Lectern");
        this.block = Block.get(BlockID.LECTERN, meta);
    }
}