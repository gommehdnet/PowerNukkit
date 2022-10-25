package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCobbledDeepslateSlab extends Item {

    public ItemCobbledDeepslateSlab() {
        this(0, 1);
    }

    public ItemCobbledDeepslateSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemCobbledDeepslateSlab(Integer meta, int count) {
        super(ItemID.COBBLED_DEEPSLATE_SLAB, meta, count, "Cobbled Deepslate Slab");
        this.block = Block.get(BlockID.COBBLED_DEEPSLATE_SLAB, meta);
    }
}