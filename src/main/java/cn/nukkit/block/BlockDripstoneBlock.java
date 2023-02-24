package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDripstoneBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DRIPSTONE_BLOCK;
    }

    @Override
    public String getName() {
        return "Dripstone Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DRIPSTONE_BLOCK);
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 1;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }
}