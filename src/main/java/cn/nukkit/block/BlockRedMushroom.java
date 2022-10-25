package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Pub4Game
 * @since 03.01.2015
 */
public class BlockRedMushroom extends BlockMushroom {

    public BlockRedMushroom() {
        super();
    }

    public BlockRedMushroom(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "Red Mushroom";
    }

    @Override
    public BlockID getId() {
        return BlockID.RED_MUSHROOM;
    }

    @Override
    protected int getType() {
        return 1;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RED_MUSHROOM);
    }
}
