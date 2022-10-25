package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoalBlock extends Item {

    public ItemCoalBlock() {
        this(0, 1);
    }

    public ItemCoalBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemCoalBlock(Integer meta, int count) {
        super(ItemID.COAL_BLOCK, meta, count, "Coal Block");
        this.block = Block.get(BlockID.COAL_BLOCK, meta);
    }
}