package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWeatheredCutCopperStairs extends BlockStairs {

    public BlockWeatheredCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WEATHERED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Weathered Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WEATHERED_CUT_COPPER_STAIRS);
    }
}