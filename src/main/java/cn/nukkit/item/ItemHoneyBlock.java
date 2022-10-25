package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHoneyBlock extends Item {

    public ItemHoneyBlock() {
        this(0, 1);
    }

    public ItemHoneyBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemHoneyBlock(Integer meta, int count) {
        super(ItemID.HONEY_BLOCK, meta, count, "Honey Block");
        this.block = Block.get(BlockID.HONEY_BLOCK, meta);
    }
}