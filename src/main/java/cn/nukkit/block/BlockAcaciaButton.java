package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockAcaciaButton extends BlockWoodenButton {

    @Override
    public BlockID getId() {
        return BlockID.ACACIA_BUTTON;
    }

    @Override
    public String getName() {
        return "Acacia Button";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ACACIA_BUTTON);
    }
}