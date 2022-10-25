package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDirtWithRoots extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DIRT_WITH_ROOTS;
    }

    @Override
    public String getName() {
        return "Dirt With Roots";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DIRT_WITH_ROOTS);
    }
}