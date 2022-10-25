package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockReserved6 extends Block {

    @Override
    public BlockID getId() {
        return BlockID.RESERVED6;
    }

    @Override
    public String getName() {
        return "Reserved6";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RESERVED6);
    }
}