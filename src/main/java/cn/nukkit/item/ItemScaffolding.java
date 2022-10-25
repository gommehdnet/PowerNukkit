package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemScaffolding extends Item {

    public ItemScaffolding() {
        this(0, 1);
    }

    public ItemScaffolding(Integer meta) {
        this(meta, 1);
    }

    public ItemScaffolding(Integer meta, int count) {
        super(ItemID.SCAFFOLDING, meta, count, "Scaffolding");
        this.block = Block.get(BlockID.SCAFFOLDING, meta);
    }
}