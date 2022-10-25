package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchStandingSign extends Item {

    public ItemBirchStandingSign() {
        this(0, 1);
    }

    public ItemBirchStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchStandingSign(Integer meta, int count) {
        super(ItemID.BIRCH_STANDING_SIGN, meta, count, "Birch Standing Sign");
        this.block = Block.get(BlockID.BIRCH_STANDING_SIGN, meta);
    }
}