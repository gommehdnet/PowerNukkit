package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveStandingSign extends Item {

    public ItemMangroveStandingSign() {
        this(0, 1);
    }

    public ItemMangroveStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveStandingSign(Integer meta, int count) {
        super(ItemID.MANGROVE_STANDING_SIGN, meta, count, "Mangrove Standing Sign");
        this.block = Block.get(BlockID.MANGROVE_STANDING_SIGN, meta);
    }
}