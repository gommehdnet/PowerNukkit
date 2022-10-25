package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockChainCommandBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CHAIN_COMMAND_BLOCK;
    }

    @Override
    public String getName() {
        return "Chain Command Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CHAIN_COMMAND_BLOCK);
    }
}