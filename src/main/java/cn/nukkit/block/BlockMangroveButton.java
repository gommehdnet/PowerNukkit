package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveButton extends BlockWoodenButton {

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_BUTTON;
    }

    @Override
    public String getName() {
        return "Mangrove Button";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_BUTTON);
    }
}