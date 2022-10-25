package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWeatheredCutCopper extends Item {

    public ItemWeatheredCutCopper() {
        this(0, 1);
    }

    public ItemWeatheredCutCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWeatheredCutCopper(Integer meta, int count) {
        super(ItemID.WEATHERED_CUT_COPPER, meta, count, "Weathered Cut Copper");
        this.block = Block.get(BlockID.WEATHERED_CUT_COPPER, meta);
    }
}