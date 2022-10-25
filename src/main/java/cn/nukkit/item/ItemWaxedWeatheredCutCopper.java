package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedWeatheredCutCopper extends Item {

    public ItemWaxedWeatheredCutCopper() {
        this(0, 1);
    }

    public ItemWaxedWeatheredCutCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedWeatheredCutCopper(Integer meta, int count) {
        super(ItemID.WAXED_WEATHERED_CUT_COPPER, meta, count, "Waxed Weathered Cut Copper");
        this.block = Block.get(BlockID.WAXED_WEATHERED_CUT_COPPER, meta);
    }
}