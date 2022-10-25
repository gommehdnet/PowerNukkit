package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateTileStairs extends Item {

    public ItemDeepslateTileStairs() {
        this(0, 1);
    }

    public ItemDeepslateTileStairs(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateTileStairs(Integer meta, int count) {
        super(ItemID.DEEPSLATE_TILE_STAIRS, meta, count, "Deepslate Tile Stairs");
        this.block = Block.get(BlockID.DEEPSLATE_TILE_STAIRS, meta);
    }
}