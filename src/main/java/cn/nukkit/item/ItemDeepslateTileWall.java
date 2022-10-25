package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateTileWall extends Item {

    public ItemDeepslateTileWall() {
        this(0, 1);
    }

    public ItemDeepslateTileWall(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateTileWall(Integer meta, int count) {
        super(ItemID.DEEPSLATE_TILE_WALL, meta, count, "Deepslate Tile Wall");
        this.block = Block.get(BlockID.DEEPSLATE_TILE_WALL, meta);
    }
}