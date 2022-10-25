package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLeaves2 extends Item {

    public ItemLeaves2() {
        this(0, 1);
    }

    public ItemLeaves2(Integer meta) {
        this(meta, 1);
    }

    public ItemLeaves2(Integer meta, int count) {
        super(ItemID.LEAVES2, meta, count, "Leaves2");
        this.block = Block.get(BlockID.LEAVES2, meta);
    }
}