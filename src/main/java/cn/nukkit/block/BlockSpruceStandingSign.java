package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockSpruceStandingSign extends BlockStandingSign {

    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_STANDING_SIGN;
    }

    @Override
    public String getName() {
        return "Spruce Standing Sign";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SPRUCE_STANDING_SIGN);
    }
}