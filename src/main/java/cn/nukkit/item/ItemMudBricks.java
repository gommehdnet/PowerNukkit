package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMudBricks extends Item {

    public ItemMudBricks() {
        this(0, 1);
    }

    public ItemMudBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemMudBricks(Integer meta, int count) {
        super(ItemID.MUD_BRICKS, meta, count, "Mud Bricks");
        this.block = Block.get(BlockID.MUD_BRICKS, meta);
    }
}