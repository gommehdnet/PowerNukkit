package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchButton extends Item {

    public ItemBirchButton() {
        this(0, 1);
    }

    public ItemBirchButton(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchButton(Integer meta, int count) {
        super(ItemID.BIRCH_BUTTON, meta, count, "Birch Button");
        this.block = Block.get(BlockID.BIRCH_BUTTON, meta);
    }
}