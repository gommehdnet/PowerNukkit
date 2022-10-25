package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockElement90 extends Block {

    @Override
    public BlockID getId() {
        return BlockID.ELEMENT_90;
    }

    @Override
    public String getName() {
        return "Element 90";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ELEMENT_90);
    }
}