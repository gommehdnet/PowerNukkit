package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockHardenedClay extends Block {

    @Override
    public BlockID getId() {
        return BlockID.HARDENED_CLAY;
    }

    @Override
    public String getName() {
        return "Hardened Clay";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.HARDENED_CLAY);
    }
}