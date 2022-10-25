package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCobbledDeepslate extends Block {

    @Override
    public BlockID getId() {
        return BlockID.COBBLED_DEEPSLATE;
    }

    @Override
    public String getName() {
        return "Cobbled Deepslate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COBBLED_DEEPSLATE);
    }
}