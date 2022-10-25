package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCommandBlock extends Item {

    public ItemCommandBlock() {
        this(0, 1);
    }

    public ItemCommandBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemCommandBlock(Integer meta, int count) {
        super(ItemID.COMMAND_BLOCK, meta, count, "Command Block");
        this.block = Block.get(BlockID.COMMAND_BLOCK, meta);
    }
}