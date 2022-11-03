package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockOxidizedCutCopperStairs extends BlockStairs {

    public BlockOxidizedCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.OXIDIZED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Oxidized Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.OXIDIZED_CUT_COPPER_STAIRS);
    }
}