package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPowderSnow extends Block {

    @Override
    public BlockID getId() {
        return BlockID.POWDER_SNOW;
    }

    @Override
    public String getName() {
        return "Powder Snow";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POWDER_SNOW);
    }
}