package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockRawIronBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.RAW_IRON_BLOCK;
    }

    @Override
    public String getName() {
        return "Raw Iron Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RAW_IRON_BLOCK);
    }
}