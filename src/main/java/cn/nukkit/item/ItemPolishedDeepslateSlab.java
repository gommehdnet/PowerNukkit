package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedDeepslateSlab extends Item {

    public ItemPolishedDeepslateSlab() {
        this(0, 1);
    }

    public ItemPolishedDeepslateSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedDeepslateSlab(Integer meta, int count) {
        super(ItemID.POLISHED_DEEPSLATE_SLAB, meta, count, "Polished Deepslate Slab");
        this.block = Block.get(BlockID.POLISHED_DEEPSLATE_SLAB, meta);
    }
}