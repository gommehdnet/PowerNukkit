package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockOxidizedCutCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.OXIDIZED_CUT_COPPER;
    }

    @Override
    public String getName() {
        return "Oxidized Cut Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.OXIDIZED_CUT_COPPER);
    }
}