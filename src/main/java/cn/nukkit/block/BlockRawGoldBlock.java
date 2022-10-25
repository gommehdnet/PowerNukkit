package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockRawGoldBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.RAW_GOLD_BLOCK;
    }

    @Override
    public String getName() {
        return "Raw Gold Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RAW_GOLD_BLOCK);
    }
}