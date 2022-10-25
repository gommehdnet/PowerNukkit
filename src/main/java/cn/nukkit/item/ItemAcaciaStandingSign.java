package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaStandingSign extends Item {

    public ItemAcaciaStandingSign() {
        this(0, 1);
    }

    public ItemAcaciaStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaStandingSign(Integer meta, int count) {
        super(ItemID.ACACIA_STANDING_SIGN, meta, count, "Acacia Standing Sign");
        this.block = Block.get(BlockID.ACACIA_STANDING_SIGN, meta);
    }
}