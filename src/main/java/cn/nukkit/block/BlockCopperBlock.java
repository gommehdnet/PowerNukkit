package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCopperBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.COPPER_BLOCK;
    }

    @Override
    public String getName() {
        return "Copper Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COPPER_BLOCK);
    }
}