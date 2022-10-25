package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockChiseledDeepslate extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CHISELED_DEEPSLATE;
    }

    @Override
    public String getName() {
        return "Chiseled Deepslate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CHISELED_DEEPSLATE);
    }
}