package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateBrickDoubleSlab extends Item {

    public ItemDeepslateBrickDoubleSlab() {
        this(0, 1);
    }

    public ItemDeepslateBrickDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateBrickDoubleSlab(Integer meta, int count) {
        super(ItemID.DEEPSLATE_BRICK_DOUBLE_SLAB, meta, count, "Deepslate Brick Double Slab");
        this.block = Block.get(BlockID.DEEPSLATE_BRICK_DOUBLE_SLAB, meta);
    }
}