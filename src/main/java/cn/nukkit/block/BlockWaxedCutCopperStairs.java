package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedCutCopperStairs extends BlockStairs {

    public BlockWaxedCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WAXED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Waxed Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_CUT_COPPER_STAIRS);
    }
}