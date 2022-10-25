package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedNetherBrick extends Item {

    public ItemRedNetherBrick() {
        this(0, 1);
    }

    public ItemRedNetherBrick(Integer meta) {
        this(meta, 1);
    }

    public ItemRedNetherBrick(Integer meta, int count) {
        super(ItemID.RED_NETHER_BRICK, meta, count, "Red Nether Brick");
        this.block = Block.get(BlockID.RED_NETHER_BRICK, meta);
    }
}