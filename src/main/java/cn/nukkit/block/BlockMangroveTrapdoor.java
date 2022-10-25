package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveTrapdoor extends BlockTrapdoor {

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_TRAPDOOR;
    }

    @Override
    public String getName() {
        return "Mangrove Trapdoor";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_TRAPDOOR);
    }
}