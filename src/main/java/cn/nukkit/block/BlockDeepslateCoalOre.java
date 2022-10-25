package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateCoalOre extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_COAL_ORE;
    }

    @Override
    public String getName() {
        return "Deepslate Coal Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_COAL_ORE);
    }
}