package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRawIronBlock extends Item {

    public ItemRawIronBlock() {
        this(0, 1);
    }

    public ItemRawIronBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemRawIronBlock(Integer meta, int count) {
        super(ItemID.RAW_IRON_BLOCK, meta, count, "Raw Iron Block");
        this.block = Block.get(BlockID.RAW_IRON_BLOCK, meta);
    }
}