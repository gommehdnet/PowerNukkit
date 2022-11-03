package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveDoor extends BlockWoodenDoor {

    public BlockMangroveDoor(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_DOOR;
    }

    @Override
    public String getName() {
        return "Mangrove Door";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_DOOR);
    }
}