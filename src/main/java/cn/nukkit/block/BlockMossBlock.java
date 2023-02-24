package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMossBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.MOSS_BLOCK;
    }

    @Override
    public String getName() {
        return "Moss Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MOSS_BLOCK);
    }

    @Override
    public double getHardness() {
        return 0.1;
    }

    @Override
    public double getResistance() {
        return 0.1;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_HOE;
    }
}