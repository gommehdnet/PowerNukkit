package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJungleStandingSign extends Item {

    public ItemJungleStandingSign() {
        this(0, 1);
    }

    public ItemJungleStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleStandingSign(Integer meta, int count) {
        super(ItemID.JUNGLE_STANDING_SIGN, meta, count, "Jungle Standing Sign");
        this.block = Block.get(BlockID.JUNGLE_STANDING_SIGN, meta);
    }
}