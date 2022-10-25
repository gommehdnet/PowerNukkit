package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedButton extends Item {

    public ItemWarpedButton() {
        this(0, 1);
    }

    public ItemWarpedButton(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedButton(Integer meta, int count) {
        super(ItemID.WARPED_BUTTON, meta, count, "Warped Button");
        this.block = Block.get(BlockID.WARPED_BUTTON, meta);
    }
}