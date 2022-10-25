package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAzaleaLeaves extends Item {

    public ItemAzaleaLeaves() {
        this(0, 1);
    }

    public ItemAzaleaLeaves(Integer meta) {
        this(meta, 1);
    }

    public ItemAzaleaLeaves(Integer meta, int count) {
        super(ItemID.AZALEA_LEAVES, meta, count, "Azalea Leaves");
        this.block = Block.get(BlockID.AZALEA_LEAVES, meta);
    }
}