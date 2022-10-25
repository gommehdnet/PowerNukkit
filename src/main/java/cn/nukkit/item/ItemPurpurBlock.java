package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPurpurBlock extends Item {

    public ItemPurpurBlock() {
        this(0, 1);
    }

    public ItemPurpurBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemPurpurBlock(Integer meta, int count) {
        super(ItemID.PURPUR_BLOCK, meta, count, "Purpur Block");
        this.block = Block.get(BlockID.PURPUR_BLOCK, meta);
    }
}