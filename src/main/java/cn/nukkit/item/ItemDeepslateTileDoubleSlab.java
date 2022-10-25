package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateTileDoubleSlab extends Item {

    public ItemDeepslateTileDoubleSlab() {
        this(0, 1);
    }

    public ItemDeepslateTileDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateTileDoubleSlab(Integer meta, int count) {
        super(ItemID.DEEPSLATE_TILE_DOUBLE_SLAB, meta, count, "Deepslate Tile Double Slab");
        this.block = Block.get(BlockID.DEEPSLATE_TILE_DOUBLE_SLAB, meta);
    }
}