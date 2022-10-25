package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWeatheredCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.WEATHERED_COPPER;
    }

    @Override
    public String getName() {
        return "Weathered Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WEATHERED_COPPER);
    }
}