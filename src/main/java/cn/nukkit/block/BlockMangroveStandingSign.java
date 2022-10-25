package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveStandingSign extends BlockStandingSign {

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_STANDING_SIGN;
    }

    @Override
    public String getName() {
        return "Mangrove Standing Sign";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_STANDING_SIGN);
    }
}