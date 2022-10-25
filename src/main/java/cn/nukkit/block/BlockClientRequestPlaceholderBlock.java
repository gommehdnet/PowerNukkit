package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockClientRequestPlaceholderBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CLIENT_REQUEST_PLACEHOLDER_BLOCK;
    }

    @Override
    public String getName() {
        return "Client Request Placeholder Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CLIENT_REQUEST_PLACEHOLDER_BLOCK);
    }
}