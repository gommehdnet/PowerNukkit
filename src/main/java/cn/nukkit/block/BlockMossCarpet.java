package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMossCarpet extends Block {

    @Override
    public BlockID getId() {
        return BlockID.MOSS_CARPET;
    }

    @Override
    public String getName() {
        return "Moss Carpet";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MOSS_CARPET);
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
    public boolean isTransparent() {
        return true;
    }
}