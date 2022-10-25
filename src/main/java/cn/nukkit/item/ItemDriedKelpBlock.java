package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDriedKelpBlock extends Item {

    public ItemDriedKelpBlock() {
        this(0, 1);
    }

    public ItemDriedKelpBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemDriedKelpBlock(Integer meta, int count) {
        super(ItemID.DRIED_KELP_BLOCK, meta, count, "Dried Kelp Block");
        this.block = Block.get(BlockID.DRIED_KELP_BLOCK, meta);
    }
}