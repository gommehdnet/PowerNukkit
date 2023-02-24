package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateGoldOre extends BlockGoldOre {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_GOLD_ORE;
    }

    @Override
    public String getName() {
        return "Deepslate Gold Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_GOLD_ORE);
    }

    @Override
    public double getHardness() {
        return super.getHardness() * 2;
    }
}