package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonButton extends Item {

    public ItemCrimsonButton() {
        this(0, 1);
    }

    public ItemCrimsonButton(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonButton(Integer meta, int count) {
        super(ItemID.CRIMSON_BUTTON, meta, count, "Crimson Button");
        this.block = Block.get(BlockID.CRIMSON_BUTTON, meta);
    }
}