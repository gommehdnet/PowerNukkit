package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveSign extends ItemSign {

    public ItemMangroveSign() {
        this(0, 1);
    }

    public ItemMangroveSign(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveSign(Integer meta, int count) {
        super(ItemID.MANGROVE_SIGN, meta, count, "Mangrove Sign");
        this.block = Block.get(BlockID.MANGROVE_STANDING_SIGN, meta);
    }
}