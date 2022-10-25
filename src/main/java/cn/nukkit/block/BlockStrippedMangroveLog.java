package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockStrippedMangroveLog extends BlockWoodStripped {

    @Override
    public BlockID getId() {
        return BlockID.STRIPPED_MANGROVE_LOG;
    }

    @Override
    public String getName() {
        return "Stripped Mangrove Log";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STRIPPED_MANGROVE_LOG);
    }
}