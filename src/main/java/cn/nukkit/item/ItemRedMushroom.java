package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedMushroom extends Item {

    public ItemRedMushroom() {
        this(0, 1);
    }

    public ItemRedMushroom(Integer meta) {
        this(meta, 1);
    }

    public ItemRedMushroom(Integer meta, int count) {
        super(ItemID.RED_MUSHROOM, meta, count, "Red Mushroom");
        this.block = Block.get(BlockID.RED_MUSHROOM, meta);
    }
}