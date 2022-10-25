package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonStandingSign extends Item {

    public ItemCrimsonStandingSign() {
        this(0, 1);
    }

    public ItemCrimsonStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonStandingSign(Integer meta, int count) {
        super(ItemID.CRIMSON_STANDING_SIGN, meta, count, "Crimson Standing Sign");
        this.block = Block.get(BlockID.CRIMSON_STANDING_SIGN, meta);
    }
}