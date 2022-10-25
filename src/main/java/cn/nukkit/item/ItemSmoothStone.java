package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSmoothStone extends Item {

    public ItemSmoothStone() {
        this(0, 1);
    }

    public ItemSmoothStone(Integer meta) {
        this(meta, 1);
    }

    public ItemSmoothStone(Integer meta, int count) {
        super(ItemID.SMOOTH_STONE, meta, count, "Smooth Stone");
        this.block = Block.get(BlockID.SMOOTH_STONE, meta);
    }
}