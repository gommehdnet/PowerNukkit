package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockExposedCutCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.EXPOSED_CUT_COPPER;
    }

    @Override
    public String getName() {
        return "Exposed Cut Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.EXPOSED_CUT_COPPER);
    }
}