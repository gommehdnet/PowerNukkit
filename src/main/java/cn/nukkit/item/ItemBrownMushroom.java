package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBrownMushroom extends Item {

    public ItemBrownMushroom() {
        this(0, 1);
    }

    public ItemBrownMushroom(Integer meta) {
        this(meta, 1);
    }

    public ItemBrownMushroom(Integer meta, int count) {
        super(ItemID.BROWN_MUSHROOM, meta, count, "Brown Mushroom");
        this.block = Block.get(BlockID.BROWN_MUSHROOM, meta);
    }
}