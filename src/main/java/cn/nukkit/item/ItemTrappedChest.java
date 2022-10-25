package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTrappedChest extends Item {

    public ItemTrappedChest() {
        this(0, 1);
    }

    public ItemTrappedChest(Integer meta) {
        this(meta, 1);
    }

    public ItemTrappedChest(Integer meta, int count) {
        super(ItemID.TRAPPED_CHEST, meta, count, "Trapped Chest");
        this.block = Block.get(BlockID.TRAPPED_CHEST, meta);
    }
}