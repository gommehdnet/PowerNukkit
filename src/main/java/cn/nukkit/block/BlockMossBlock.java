package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMossBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.MOSS_BLOCK;
    }

    @Override
    public String getName() {
        return "Moss Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MOSS_BLOCK);
    }
}