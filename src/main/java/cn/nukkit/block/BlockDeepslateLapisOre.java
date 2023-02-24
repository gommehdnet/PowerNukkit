package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateLapisOre extends BlockLapisOre {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_LAPIS_ORE;
    }

    @Override
    public String getName() {
        return "Deepslate Lapis Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_LAPIS_ORE);
    }

    @Override
    public double getHardness() {
        return super.getHardness() * 2;
    }
}