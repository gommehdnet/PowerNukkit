package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateIronOre extends BlockIronOre {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_IRON_ORE;
    }

    @Override
    public String getName() {
        return "Deepslate Iron Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_IRON_ORE);
    }

    @Override
    public double getHardness() {
        return super.getHardness() * 2;
    }
}