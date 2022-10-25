package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveWallSign extends BlockWallSign {

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_WALL_SIGN;
    }

    @Override
    public String getName() {
        return "Mangrove Wall Sign";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_WALL_SIGN);
    }
}