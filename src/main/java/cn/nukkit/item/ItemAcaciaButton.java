package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaButton extends Item {

    public ItemAcaciaButton() {
        this(0, 1);
    }

    public ItemAcaciaButton(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaButton(Integer meta, int count) {
        super(ItemID.ACACIA_BUTTON, meta, count, "Acacia Button");
        this.block = Block.get(BlockID.ACACIA_BUTTON, meta);
    }
}