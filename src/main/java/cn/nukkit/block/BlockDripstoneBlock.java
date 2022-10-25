package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDripstoneBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DRIPSTONE_BLOCK;
    }

    @Override
    public String getName() {
        return "Dripstone Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DRIPSTONE_BLOCK);
    }
}