package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrackedDeepslateTiles extends Item {

    public ItemCrackedDeepslateTiles() {
        this(0, 1);
    }

    public ItemCrackedDeepslateTiles(Integer meta) {
        this(meta, 1);
    }

    public ItemCrackedDeepslateTiles(Integer meta, int count) {
        super(ItemID.CRACKED_DEEPSLATE_TILES, meta, count, "Cracked Deepslate Tiles");
        this.block = Block.get(BlockID.CRACKED_DEEPSLATE_TILES, meta);
    }
}