package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedWeatheredCutCopperStairs extends BlockStairs {

    public BlockWaxedWeatheredCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WAXED_WEATHERED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Waxed Weathered Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_WEATHERED_CUT_COPPER_STAIRS);
    }
}