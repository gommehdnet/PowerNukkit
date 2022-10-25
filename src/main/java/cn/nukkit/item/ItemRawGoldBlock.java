package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRawGoldBlock extends Item {

    public ItemRawGoldBlock() {
        this(0, 1);
    }

    public ItemRawGoldBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemRawGoldBlock(Integer meta, int count) {
        super(ItemID.RAW_GOLD_BLOCK, meta, count, "Raw Gold Block");
        this.block = Block.get(BlockID.RAW_GOLD_BLOCK, meta);
    }
}