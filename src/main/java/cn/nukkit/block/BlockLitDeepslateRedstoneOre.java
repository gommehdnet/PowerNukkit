package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockLitDeepslateRedstoneOre extends Block {

    @Override
    public BlockID getId() {
        return BlockID.LIT_DEEPSLATE_REDSTONE_ORE;
    }

    @Override
    public String getName() {
        return "Lit Deepslate Redstone Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIT_DEEPSLATE_REDSTONE_ORE);
    }
}