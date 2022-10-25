package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveRoots extends Block {

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_ROOTS;
    }

    @Override
    public String getName() {
        return "Mangrove Roots";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_ROOTS);
    }
}