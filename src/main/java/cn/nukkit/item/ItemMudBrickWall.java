package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMudBrickWall extends Item {

    public ItemMudBrickWall() {
        this(0, 1);
    }

    public ItemMudBrickWall(Integer meta) {
        this(meta, 1);
    }

    public ItemMudBrickWall(Integer meta, int count) {
        super(ItemID.MUD_BRICK_WALL, meta, count, "Mud Brick Wall");
        this.block = Block.get(BlockID.MUD_BRICK_WALL, meta);
    }
}