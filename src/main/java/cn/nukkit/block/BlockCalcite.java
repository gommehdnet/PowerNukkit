package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

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

    @Override
    public double getHardness() {
        return 0.75;
    }

    @Override
    public double getResistance() {
        return 0.75;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }
}