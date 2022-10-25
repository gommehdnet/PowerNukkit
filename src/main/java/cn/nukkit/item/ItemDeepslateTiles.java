package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateTiles extends Item {

    public ItemDeepslateTiles() {
        this(0, 1);
    }

    public ItemDeepslateTiles(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateTiles(Integer meta, int count) {
        super(ItemID.DEEPSLATE_TILES, meta, count, "Deepslate Tiles");
        this.block = Block.get(BlockID.DEEPSLATE_TILES, meta);
    }
}