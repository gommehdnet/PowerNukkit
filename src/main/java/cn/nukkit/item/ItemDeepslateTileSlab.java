package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateTileSlab extends Item {

    public ItemDeepslateTileSlab() {
        this(0, 1);
    }

    public ItemDeepslateTileSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateTileSlab(Integer meta, int count) {
        super(ItemID.DEEPSLATE_TILE_SLAB, meta, count, "Deepslate Tile Slab");
        this.block = Block.get(BlockID.DEEPSLATE_TILE_SLAB, meta);
    }
}