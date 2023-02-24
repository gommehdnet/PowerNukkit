package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockTuff extends Block {

    @Override
    public BlockID getId() {
        return BlockID.TUFF;
    }

    @Override
    public String getName() {
        return "Tuff";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.TUFF);
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 6;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }
}