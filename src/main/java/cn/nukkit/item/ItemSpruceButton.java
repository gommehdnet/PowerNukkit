package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpruceButton extends Item {

    public ItemSpruceButton() {
        this(0, 1);
    }

    public ItemSpruceButton(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceButton(Integer meta, int count) {
        super(ItemID.SPRUCE_BUTTON, meta, count, "Spruce Button");
        this.block = Block.get(BlockID.SPRUCE_BUTTON, meta);
    }
}