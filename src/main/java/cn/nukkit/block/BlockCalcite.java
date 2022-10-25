package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCalcite extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CALCITE;
    }

    @Override
    public String getName() {
        return "Calcite";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CALCITE);
    }
}