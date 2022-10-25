package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChest extends Item {

    public ItemChest() {
        this(0, 1);
    }

    public ItemChest(Integer meta) {
        this(meta, 1);
    }

    public ItemChest(Integer meta, int count) {
        super(ItemID.CHEST, meta, count, "Chest");
        this.block = Block.get(BlockID.CHEST, meta);
    }
}