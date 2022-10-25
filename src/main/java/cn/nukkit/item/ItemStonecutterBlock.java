package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStonecutterBlock extends Item {

    public ItemStonecutterBlock() {
        this(0, 1);
    }

    public ItemStonecutterBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemStonecutterBlock(Integer meta, int count) {
        super(ItemID.STONECUTTER_BLOCK, meta, count, "Stonecutter Block");
        this.block = Block.get(BlockID.STONECUTTER_BLOCK, meta);
    }
}