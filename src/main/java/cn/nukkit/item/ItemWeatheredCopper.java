package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWeatheredCopper extends Item {

    public ItemWeatheredCopper() {
        this(0, 1);
    }

    public ItemWeatheredCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWeatheredCopper(Integer meta, int count) {
        super(ItemID.WEATHERED_COPPER, meta, count, "Weathered Copper");
        this.block = Block.get(BlockID.WEATHERED_COPPER, meta);
    }
}