package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlueIce extends Item {

    public ItemBlueIce() {
        this(0, 1);
    }

    public ItemBlueIce(Integer meta) {
        this(meta, 1);
    }

    public ItemBlueIce(Integer meta, int count) {
        super(ItemID.BLUE_ICE, meta, count, "Blue Ice");
        this.block = Block.get(BlockID.BLUE_ICE, meta);
    }
}