package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveStairs extends BlockOakStairs {

    public BlockMangroveStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_STAIRS;
    }

    @Override
    public String getName() {
        return "Mangrove Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_STAIRS);
    }
}