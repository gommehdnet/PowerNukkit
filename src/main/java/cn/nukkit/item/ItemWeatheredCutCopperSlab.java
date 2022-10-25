package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWeatheredCutCopperSlab extends Item {

    public ItemWeatheredCutCopperSlab() {
        this(0, 1);
    }

    public ItemWeatheredCutCopperSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemWeatheredCutCopperSlab(Integer meta, int count) {
        super(ItemID.WEATHERED_CUT_COPPER_SLAB, meta, count, "Weathered Cut Copper Slab");
        this.block = Block.get(BlockID.WEATHERED_CUT_COPPER_SLAB, meta);
    }
}