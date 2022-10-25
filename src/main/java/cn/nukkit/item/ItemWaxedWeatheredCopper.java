package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedWeatheredCopper extends Item {

    public ItemWaxedWeatheredCopper() {
        this(0, 1);
    }

    public ItemWaxedWeatheredCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedWeatheredCopper(Integer meta, int count) {
        super(ItemID.WAXED_WEATHERED_COPPER, meta, count, "Waxed Weathered Copper");
        this.block = Block.get(BlockID.WAXED_WEATHERED_COPPER, meta);
    }
}