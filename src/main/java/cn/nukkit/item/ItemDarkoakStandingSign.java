package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkoakStandingSign extends Item {

    public ItemDarkoakStandingSign() {
        this(0, 1);
    }

    public ItemDarkoakStandingSign(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkoakStandingSign(Integer meta, int count) {
        super(ItemID.DARKOAK_STANDING_SIGN, meta, count, "Darkoak Standing Sign");
        this.block = Block.get(BlockID.DARKOAK_STANDING_SIGN, meta);
    }
}