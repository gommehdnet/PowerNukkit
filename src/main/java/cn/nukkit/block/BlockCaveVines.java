package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCaveVines extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CAVE_VINES;
    }

    @Override
    public String getName() {
        return "Cave Vines";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CAVE_VINES);
    }
}