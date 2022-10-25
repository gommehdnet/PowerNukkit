package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateRedstoneOre extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_REDSTONE_ORE;
    }

    @Override
    public String getName() {
        return "Deepslate Redstone Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_REDSTONE_ORE);
    }
}