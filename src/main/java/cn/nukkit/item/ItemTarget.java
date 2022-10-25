package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTarget extends Item {

    public ItemTarget() {
        this(0, 1);
    }

    public ItemTarget(Integer meta) {
        this(meta, 1);
    }

    public ItemTarget(Integer meta, int count) {
        super(ItemID.TARGET, meta, count, "Target");
        this.block = Block.get(BlockID.TARGET, meta);
    }
}