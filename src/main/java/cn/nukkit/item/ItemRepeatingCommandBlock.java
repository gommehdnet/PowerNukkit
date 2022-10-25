package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRepeatingCommandBlock extends Item {

    public ItemRepeatingCommandBlock() {
        this(0, 1);
    }

    public ItemRepeatingCommandBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemRepeatingCommandBlock(Integer meta, int count) {
        super(ItemID.REPEATING_COMMAND_BLOCK, meta, count, "Repeating Command Block");
        this.block = Block.get(BlockID.REPEATING_COMMAND_BLOCK, meta);
    }
}