package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemShulkerBox extends Item {

    public ItemShulkerBox() {
        this(0, 1);
    }

    public ItemShulkerBox(Integer meta) {
        this(meta, 1);
    }

    public ItemShulkerBox(Integer meta, int count) {
        super(ItemID.SHULKER_BOX, meta, count, "Shulker Box");
        this.block = Block.get(BlockID.SHULKER_BOX, meta);
    }
}