package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockElement84 extends Block {

    @Override
    public BlockID getId() {
        return BlockID.ELEMENT_84;
    }

    @Override
    public String getName() {
        return "Element 84";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ELEMENT_84);
    }
}