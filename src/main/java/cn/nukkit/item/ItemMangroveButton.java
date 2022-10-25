package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveButton extends Item {

    public ItemMangroveButton() {
        this(0, 1);
    }

    public ItemMangroveButton(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveButton(Integer meta, int count) {
        super(ItemID.MANGROVE_BUTTON, meta, count, "Mangrove Button");
        this.block = Block.get(BlockID.MANGROVE_BUTTON, meta);
    }
}