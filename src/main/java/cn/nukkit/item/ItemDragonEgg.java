package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDragonEgg extends Item {

    public ItemDragonEgg() {
        this(0, 1);
    }

    public ItemDragonEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemDragonEgg(Integer meta, int count) {
        super(ItemID.DRAGON_EGG, meta, count, "Dragon Egg");
        this.block = Block.get(BlockID.DRAGON_EGG, meta);
    }
}