package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGoldBlock extends Item {

    public ItemGoldBlock() {
        this(0, 1);
    }

    public ItemGoldBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldBlock(Integer meta, int count) {
        super(ItemID.GOLD_BLOCK, meta, count, "Gold Block");
        this.block = Block.get(BlockID.GOLD_BLOCK, meta);
    }
}