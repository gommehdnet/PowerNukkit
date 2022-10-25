package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEnderChest extends Item {

    public ItemEnderChest() {
        this(0, 1);
    }

    public ItemEnderChest(Integer meta) {
        this(meta, 1);
    }

    public ItemEnderChest(Integer meta, int count) {
        super(ItemID.ENDER_CHEST, meta, count, "Ender Chest");
        this.block = Block.get(BlockID.ENDER_CHEST, meta);
    }
}