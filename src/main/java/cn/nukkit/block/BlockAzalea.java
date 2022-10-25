package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockAzalea extends Block {

    @Override
    public BlockID getId() {
        return BlockID.AZALEA;
    }

    @Override
    public String getName() {
        return "Azalea";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.AZALEA);
    }
}