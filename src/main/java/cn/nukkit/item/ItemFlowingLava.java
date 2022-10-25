package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFlowingLava extends Item {

    public ItemFlowingLava() {
        this(0, 1);
    }

    public ItemFlowingLava(Integer meta) {
        this(meta, 1);
    }

    public ItemFlowingLava(Integer meta, int count) {
        super(ItemID.FLOWING_LAVA, meta, count, "Flowing Lava");
        this.block = Block.get(BlockID.FLOWING_LAVA, meta);
    }
}