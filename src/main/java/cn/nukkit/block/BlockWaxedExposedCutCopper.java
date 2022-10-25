package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedExposedCutCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.WAXED_EXPOSED_CUT_COPPER;
    }

    @Override
    public String getName() {
        return "Waxed Exposed Cut Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_EXPOSED_CUT_COPPER);
    }
}