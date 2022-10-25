package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRawCopperBlock extends Item {

    public ItemRawCopperBlock() {
        this(0, 1);
    }

    public ItemRawCopperBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemRawCopperBlock(Integer meta, int count) {
        super(ItemID.RAW_COPPER_BLOCK, meta, count, "Raw Copper Block");
        this.block = Block.get(BlockID.RAW_COPPER_BLOCK, meta);
    }
}