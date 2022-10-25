package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateCopperOre extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_COPPER_ORE;
    }

    @Override
    public String getName() {
        return "Deepslate Copper Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_COPPER_ORE);
    }
}