package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedExposedCutCopperStairs extends BlockStairs {

    public BlockWaxedExposedCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WAXED_EXPOSED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Waxed Exposed Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_EXPOSED_CUT_COPPER_STAIRS);
    }
}