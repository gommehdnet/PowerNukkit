package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHoneycombBlock extends Item {

    public ItemHoneycombBlock() {
        this(0, 1);
    }

    public ItemHoneycombBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemHoneycombBlock(Integer meta, int count) {
        super(ItemID.HONEYCOMB_BLOCK, meta, count, "Honeycomb Block");
        this.block = Block.get(BlockID.HONEYCOMB_BLOCK, meta);
    }
}