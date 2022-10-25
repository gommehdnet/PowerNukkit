package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateBrickSlab extends Item {

    public ItemDeepslateBrickSlab() {
        this(0, 1);
    }

    public ItemDeepslateBrickSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateBrickSlab(Integer meta, int count) {
        super(ItemID.DEEPSLATE_BRICK_SLAB, meta, count, "Deepslate Brick Slab");
        this.block = Block.get(BlockID.DEEPSLATE_BRICK_SLAB, meta);
    }
}