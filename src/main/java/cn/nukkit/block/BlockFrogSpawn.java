package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockFrogSpawn extends Block {

    @Override
    public BlockID getId() {
        return BlockID.FROG_SPAWN;
    }

    @Override
    public String getName() {
        return "Frog Spawn";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.FROG_SPAWN);
    }
}