package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWoodenButton extends Item {

    public ItemWoodenButton() {
        this(0, 1);
    }

    public ItemWoodenButton(Integer meta) {
        this(meta, 1);
    }

    public ItemWoodenButton(Integer meta, int count) {
        super(ItemID.WOODEN_BUTTON, meta, count, "Wooden Button");
        this.block = Block.get(BlockID.WOODEN_BUTTON, meta);
    }
}