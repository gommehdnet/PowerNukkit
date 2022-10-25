package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPolishedDeepslate extends Block {

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_DEEPSLATE;
    }

    @Override
    public String getName() {
        return "Polished Deepslate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_DEEPSLATE);
    }
}