package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockInfoUpdate2 extends Block {

    @Override
    public BlockID getId() {
        return BlockID.INFO_UPDATE2;
    }

    @Override
    public String getName() {
        return "Info Update2";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.INFO_UPDATE2);
    }
}