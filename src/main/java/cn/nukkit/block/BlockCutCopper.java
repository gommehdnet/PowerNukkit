package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCutCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CUT_COPPER;
    }

    @Override
    public String getName() {
        return "Cut Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CUT_COPPER);
    }
}