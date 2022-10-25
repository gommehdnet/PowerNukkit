package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockReinforcedDeepslate extends Block {

    @Override
    public BlockID getId() {
        return BlockID.REINFORCED_DEEPSLATE;
    }

    @Override
    public String getName() {
        return "Reinforced Deepslate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.REINFORCED_DEEPSLATE);
    }
}