package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCopperBlock extends Item {

    public ItemCopperBlock() {
        this(0, 1);
    }

    public ItemCopperBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemCopperBlock(Integer meta, int count) {
        super(ItemID.COPPER_BLOCK, meta, count, "Copper Block");
        this.block = Block.get(BlockID.COPPER_BLOCK, meta);
    }
}