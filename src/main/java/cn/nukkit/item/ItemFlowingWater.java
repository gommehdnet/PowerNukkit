package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFlowingWater extends Item {

    public ItemFlowingWater() {
        this(0, 1);
    }

    public ItemFlowingWater(Integer meta) {
        this(meta, 1);
    }

    public ItemFlowingWater(Integer meta, int count) {
        super(ItemID.FLOWING_WATER, meta, count, "Flowing Water");
        this.block = Block.get(BlockID.FLOWING_WATER, meta);
    }
}