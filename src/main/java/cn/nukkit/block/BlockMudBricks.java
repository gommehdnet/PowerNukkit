package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMudBricks extends Block {

    @Override
    public BlockID getId() {
        return BlockID.MUD_BRICKS;
    }

    @Override
    public String getName() {
        return "Mud Bricks";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MUD_BRICKS);
    }
}