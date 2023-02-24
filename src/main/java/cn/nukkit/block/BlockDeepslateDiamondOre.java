package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateDiamondOre extends BlockDiamondOre {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_DIAMOND_ORE;
    }

    @Override
    public String getName() {
        return "Deepslate Diamond Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_DIAMOND_ORE);
    }

    @Override
    public double getHardness() {
        return super.getHardness() * 2;
    }
}