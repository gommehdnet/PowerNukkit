package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstoneButton extends Item {

    public ItemPolishedBlackstoneButton() {
        this(0, 1);
    }

    public ItemPolishedBlackstoneButton(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstoneButton(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_BUTTON, meta, count, "Polished Blackstone Button");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_BUTTON, meta);
    }
}