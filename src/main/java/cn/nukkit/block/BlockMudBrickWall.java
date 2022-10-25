package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMudBrickWall extends BlockWallBase {

    public BlockMudBrickWall(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.MUD_BRICK_WALL;
    }

    @Override
    public String getName() {
        return "Mud Brick Wall";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MUD_BRICK_WALL);
    }
}