package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockElement11 extends Block {

    @Override
    public BlockID getId() {
        return BlockID.ELEMENT_11;
    }

    @Override
    public String getName() {
        return "Element 11";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ELEMENT_11);
    }
}