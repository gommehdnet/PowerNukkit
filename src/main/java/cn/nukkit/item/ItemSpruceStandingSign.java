package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpruceStandingSign extends Item {

    public ItemSpruceStandingSign() {
        this(0, 1);
    }

    public ItemSpruceStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceStandingSign(Integer meta, int count) {
        super(ItemID.SPRUCE_STANDING_SIGN, meta, count, "Spruce Standing Sign");
        this.block = Block.get(BlockID.SPRUCE_STANDING_SIGN, meta);
    }
}