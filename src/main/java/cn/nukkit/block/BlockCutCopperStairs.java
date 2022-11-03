package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCutCopperStairs extends BlockStairs {

    public BlockCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CUT_COPPER_STAIRS);
    }
}