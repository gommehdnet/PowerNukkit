package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockChemistryTable extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CHEMISTRY_TABLE;
    }

    @Override
    public String getName() {
        return "Chemistry Table";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CHEMISTRY_TABLE);
    }
}