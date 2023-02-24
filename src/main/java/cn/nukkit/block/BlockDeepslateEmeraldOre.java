package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateEmeraldOre extends BlockEmeraldOre {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_EMERALD_ORE;
    }

    @Override
    public String getName() {
        return "Deepslate Emerald Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_EMERALD_ORE);
    }

    @Override
    public double getHardness() {
        return super.getHardness() * 2;
    }
}