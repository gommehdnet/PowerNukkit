package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateBrickStairs extends BlockStairs {

    protected BlockDeepslateBrickStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_BRICK_STAIRS;
    }

    @Override
    public String getName() {
        return "Deepslate Brick Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_BRICK_STAIRS);
    }
}