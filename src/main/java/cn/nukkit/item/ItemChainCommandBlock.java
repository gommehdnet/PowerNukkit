package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChainCommandBlock extends Item {

    public ItemChainCommandBlock() {
        this(0, 1);
    }

    public ItemChainCommandBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemChainCommandBlock(Integer meta, int count) {
        super(ItemID.CHAIN_COMMAND_BLOCK, meta, count, "Chain Command Block");
        this.block = Block.get(BlockID.CHAIN_COMMAND_BLOCK, meta);
    }
}