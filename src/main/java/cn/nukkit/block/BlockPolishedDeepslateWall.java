package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPolishedDeepslateWall extends BlockWallBase {

    public BlockPolishedDeepslateWall(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_DEEPSLATE_WALL;
    }

    @Override
    public String getName() {
        return "Polished Deepslate Wall";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_DEEPSLATE_WALL);
    }
}