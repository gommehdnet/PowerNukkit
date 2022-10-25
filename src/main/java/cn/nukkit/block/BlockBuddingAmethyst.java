package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockBuddingAmethyst extends Block {

    @Override
    public BlockID getId() {
        return BlockID.BUDDING_AMETHYST;
    }

    @Override
    public String getName() {
        return "Budding Amethyst";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BUDDING_AMETHYST);
    }
}