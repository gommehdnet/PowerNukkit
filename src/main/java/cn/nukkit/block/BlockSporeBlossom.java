package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockSporeBlossom extends Block {

    @Override
    public BlockID getId() {
        return BlockID.SPORE_BLOSSOM;
    }

    @Override
    public String getName() {
        return "Spore Blossom";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SPORE_BLOSSOM);
    }
}