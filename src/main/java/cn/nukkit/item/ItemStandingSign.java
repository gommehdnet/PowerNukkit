package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStandingSign extends Item {

    public ItemStandingSign() {
        this(0, 1);
    }

    public ItemStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemStandingSign(Integer meta, int count) {
        super(ItemID.STANDING_SIGN, meta, count, "Standing Sign");
        this.block = Block.get(BlockID.STANDING_SIGN);
    }
}