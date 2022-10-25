package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateBrickWall extends Item {

    public ItemDeepslateBrickWall() {
        this(0, 1);
    }

    public ItemDeepslateBrickWall(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateBrickWall(Integer meta, int count) {
        super(ItemID.DEEPSLATE_BRICK_WALL, meta, count, "Deepslate Brick Wall");
        this.block = Block.get(BlockID.DEEPSLATE_BRICK_WALL, meta);
    }
}