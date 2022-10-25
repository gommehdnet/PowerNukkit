package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCaveVinesHeadWithBerries extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CAVE_VINES_HEAD_WITH_BERRIES;
    }

    @Override
    public String getName() {
        return "Cave Vines Head With Berries";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CAVE_VINES_HEAD_WITH_BERRIES);
    }
}