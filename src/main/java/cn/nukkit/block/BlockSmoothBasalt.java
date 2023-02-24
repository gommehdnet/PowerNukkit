package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockSmoothBasalt extends BlockBasalt {

    @Override
    public BlockID getId() {
        return BlockID.SMOOTH_BASALT;
    }

    @Override
    public String getName() {
        return "Smooth Basalt";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SMOOTH_BASALT);
    }
}