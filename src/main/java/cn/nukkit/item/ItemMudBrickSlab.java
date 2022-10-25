package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMudBrickSlab extends Item {

    public ItemMudBrickSlab() {
        this(0, 1);
    }

    public ItemMudBrickSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemMudBrickSlab(Integer meta, int count) {
        super(ItemID.MUD_BRICK_SLAB, meta, count, "Mud Brick Slab");
        this.block = Block.get(BlockID.MUD_BRICK_SLAB, meta);
    }
}