package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockChemicalHeat extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CHEMICAL_HEAT;
    }

    @Override
    public String getName() {
        return "Chemical Heat";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CHEMICAL_HEAT);
    }
}