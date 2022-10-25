package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCommandBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.COMMAND_BLOCK;
    }

    @Override
    public String getName() {
        return "Command Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COMMAND_BLOCK);
    }
}