package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDropper extends Item {

    public ItemDropper() {
        this(0, 1);
    }

    public ItemDropper(Integer meta) {
        this(meta, 1);
    }

    public ItemDropper(Integer meta, int count) {
        super(ItemID.DROPPER, meta, count, "Dropper");
        this.block = Block.get(BlockID.DROPPER, meta);
    }
}