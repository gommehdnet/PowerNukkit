package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStoneButton extends Item {

    public ItemStoneButton() {
        this(0, 1);
    }

    public ItemStoneButton(Integer meta) {
        this(meta, 1);
    }

    public ItemStoneButton(Integer meta, int count) {
        super(ItemID.STONE_BUTTON, meta, count, "Stone Button");
        this.block = Block.get(BlockID.STONE_BUTTON, meta);
    }
}