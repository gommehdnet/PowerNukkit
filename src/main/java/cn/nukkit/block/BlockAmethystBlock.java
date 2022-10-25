package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockAmethystBlock extends Block {

    @Override
    public BlockID getId() {
        return BlockID.AMETHYST_BLOCK;
    }

    @Override
    public String getName() {
        return "Amethyst Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.AMETHYST_BLOCK);
    }
}