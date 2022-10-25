package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockExposedCutCopperStairs extends BlockStairs {

    protected BlockExposedCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.EXPOSED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Exposed Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.EXPOSED_CUT_COPPER_STAIRS);
    }
}