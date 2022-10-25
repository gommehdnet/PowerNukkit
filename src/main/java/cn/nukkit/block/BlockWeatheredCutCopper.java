package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWeatheredCutCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.WEATHERED_CUT_COPPER;
    }

    @Override
    public String getName() {
        return "Weathered Cut Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WEATHERED_CUT_COPPER);
    }
}