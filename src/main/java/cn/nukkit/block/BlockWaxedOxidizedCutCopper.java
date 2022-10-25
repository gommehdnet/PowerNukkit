package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedOxidizedCutCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.WAXED_OXIDIZED_CUT_COPPER;
    }

    @Override
    public String getName() {
        return "Waxed Oxidized Cut Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_OXIDIZED_CUT_COPPER);
    }
}