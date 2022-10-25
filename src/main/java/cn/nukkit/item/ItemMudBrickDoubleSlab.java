package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMudBrickDoubleSlab extends Item {

    public ItemMudBrickDoubleSlab() {
        this(0, 1);
    }

    public ItemMudBrickDoubleSlab(Integer meta) {
        this(meta, 1);
    }

    public ItemMudBrickDoubleSlab(Integer meta, int count) {
        super(ItemID.MUD_BRICK_DOUBLE_SLAB, meta, count, "Mud Brick Double Slab");
        this.block = Block.get(BlockID.MUD_BRICK_DOUBLE_SLAB, meta);
    }
}