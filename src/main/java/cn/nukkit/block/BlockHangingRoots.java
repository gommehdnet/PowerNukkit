package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockHangingRoots extends Block {

    @Override
    public BlockID getId() {
        return BlockID.HANGING_ROOTS;
    }

    @Override
    public String getName() {
        return "Hanging Roots";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.HANGING_ROOTS);
    }
}