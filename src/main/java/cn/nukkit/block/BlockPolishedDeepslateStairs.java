package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPolishedDeepslateStairs extends BlockStairs {

    protected BlockPolishedDeepslateStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_DEEPSLATE_STAIRS;
    }

    @Override
    public String getName() {
        return "Polished Deepslate Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_DEEPSLATE_STAIRS);
    }
}