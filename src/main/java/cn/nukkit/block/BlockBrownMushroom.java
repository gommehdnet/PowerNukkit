package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Nukkit Project Team
 */
public class BlockBrownMushroom extends BlockMushroom {

    public BlockBrownMushroom() {
        super();
    }

    public BlockBrownMushroom(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "Brown Mushroom";
    }

    @Override
    public BlockID getId() {
        return BlockID.BROWN_MUSHROOM;
    }

    @Override
    public int getLightLevel() {
        return 1;
    }

    @Override
    protected int getType() {
        return 0;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BROWN_MUSHROOM);
    }
}
