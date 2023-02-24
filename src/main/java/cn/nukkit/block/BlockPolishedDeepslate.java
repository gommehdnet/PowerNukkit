package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPolishedDeepslate extends Block {

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_DEEPSLATE;
    }

    @Override
    public String getName() {
        return "Polished Deepslate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_DEEPSLATE);
    }

    @Override
    public double getHardness() {
        return 3.5;
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