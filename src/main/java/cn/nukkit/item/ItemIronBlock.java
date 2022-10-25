package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemIronBlock extends Item {

    public ItemIronBlock() {
        this(0, 1);
    }

    public ItemIronBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemIronBlock(Integer meta, int count) {
        super(ItemID.IRON_BLOCK, meta, count, "Iron Block");
        this.block = Block.get(BlockID.IRON_BLOCK, meta);
    }
}