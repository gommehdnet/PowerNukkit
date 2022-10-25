package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemConcretePowder extends Item {

    public ItemConcretePowder() {
        this(0, 1);
    }

    public ItemConcretePowder(Integer meta) {
        this(meta, 1);
    }

    public ItemConcretePowder(Integer meta, int count) {
        super(ItemID.CONCRETE_POWDER, meta, count, "Concrete Powder");
        this.block = Block.get(BlockID.CONCRETE_POWDER, meta);
    }
}