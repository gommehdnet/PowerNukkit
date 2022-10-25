package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedWeatheredCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.WAXED_WEATHERED_COPPER;
    }

    @Override
    public String getName() {
        return "Waxed Weathered Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_WEATHERED_COPPER);
    }
}