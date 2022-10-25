package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAzaleaLeavesFlowered extends Item {

    public ItemAzaleaLeavesFlowered() {
        this(0, 1);
    }

    public ItemAzaleaLeavesFlowered(Integer meta) {
        this(meta, 1);
    }

    public ItemAzaleaLeavesFlowered(Integer meta, int count) {
        super(ItemID.AZALEA_LEAVES_FLOWERED, meta, count, "Azalea Leaves Flowered");
        this.block = Block.get(BlockID.AZALEA_LEAVES_FLOWERED, meta);
    }
}