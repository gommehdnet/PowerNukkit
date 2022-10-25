package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLoom extends Item {

    public ItemLoom() {
        this(0, 1);
    }

    public ItemLoom(Integer meta) {
        this(meta, 1);
    }

    public ItemLoom(Integer meta, int count) {
        super(ItemID.LOOM, meta, count, "Loom");
        this.block = Block.get(BlockID.LOOM, meta);
    }
}