package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedstoneLamp extends Item {

    public ItemRedstoneLamp() {
        this(0, 1);
    }

    public ItemRedstoneLamp(Integer meta) {
        this(meta, 1);
    }

    public ItemRedstoneLamp(Integer meta, int count) {
        super(ItemID.REDSTONE_LAMP, meta, count, "Redstone Lamp");
        this.block = Block.get(BlockID.REDSTONE_LAMP, meta);
    }
}