package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockHardStainedGlass extends Block {

    @Override
    public BlockID getId() {
        return BlockID.HARD_STAINED_GLASS;
    }

    @Override
    public String getName() {
        return "Hard Stained Glass";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.HARD_STAINED_GLASS);
    }
}