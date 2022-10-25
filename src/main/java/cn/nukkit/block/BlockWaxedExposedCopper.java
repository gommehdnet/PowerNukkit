package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedExposedCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.WAXED_EXPOSED_COPPER;
    }

    @Override
    public String getName() {
        return "Waxed Exposed Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_EXPOSED_COPPER);
    }
}