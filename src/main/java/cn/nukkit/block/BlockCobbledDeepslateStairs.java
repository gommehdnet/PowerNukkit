package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCobbledDeepslateStairs extends BlockStairs {

    public BlockCobbledDeepslateStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.COBBLED_DEEPSLATE_STAIRS;
    }

    @Override
    public String getName() {
        return "Cobbled Deepslate Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COBBLED_DEEPSLATE_STAIRS);
    }
}