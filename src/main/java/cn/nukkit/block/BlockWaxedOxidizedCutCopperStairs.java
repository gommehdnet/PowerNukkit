package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedOxidizedCutCopperStairs extends BlockStairs {

    public BlockWaxedOxidizedCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WAXED_OXIDIZED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Waxed Oxidized Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_OXIDIZED_CUT_COPPER_STAIRS);
    }
}