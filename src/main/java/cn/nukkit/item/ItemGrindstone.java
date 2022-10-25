package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGrindstone extends Item {

    public ItemGrindstone() {
        this(0, 1);
    }

    public ItemGrindstone(Integer meta) {
        this(meta, 1);
    }

    public ItemGrindstone(Integer meta, int count) {
        super(ItemID.GRINDSTONE, meta, count, "Grindstone");
        this.block = Block.get(BlockID.GRINDSTONE, meta);
    }
}