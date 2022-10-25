package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockInfoUpdate extends Block {

    @Override
    public BlockID getId() {
        return BlockID.INFO_UPDATE;
    }

    @Override
    public String getName() {
        return "Info Update";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.INFO_UPDATE);
    }
}