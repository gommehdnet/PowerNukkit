package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockTintedGlass extends Block {

    @Override
    public BlockID getId() {
        return BlockID.TINTED_GLASS;
    }

    @Override
    public String getName() {
        return "Tinted Glass";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.TINTED_GLASS);
    }
}