package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCobbledDeepslateWall extends BlockWallBase {

    public BlockCobbledDeepslateWall(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.COBBLED_DEEPSLATE_WALL;
    }

    @Override
    public String getName() {
        return "Cobbled Deepslate Wall";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COBBLED_DEEPSLATE_WALL);
    }
}