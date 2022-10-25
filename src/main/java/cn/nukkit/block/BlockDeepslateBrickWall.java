package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateBrickWall extends BlockWallBase {

    public BlockDeepslateBrickWall(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_BRICK_WALL;
    }

    @Override
    public String getName() {
        return "Deepslate Brick Wall";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_BRICK_WALL);
    }
}