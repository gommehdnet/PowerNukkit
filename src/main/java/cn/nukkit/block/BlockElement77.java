package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockElement77 extends Block {

    @Override
    public BlockID getId() {
        return BlockID.ELEMENT_77;
    }

    @Override
    public String getName() {
        return "Element 77";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ELEMENT_77);
    }
}