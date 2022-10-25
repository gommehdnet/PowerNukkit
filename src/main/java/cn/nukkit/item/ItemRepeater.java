package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author CreeperFace
 */
public class ItemRepeater extends Item {

    public ItemRepeater() {
        this(0);
    }

    public ItemRepeater(Integer meta) {
        this(0, 1);
    }

    public ItemRepeater(Integer meta, int count) {
        super(ItemID.REPEATER, meta, count, "Redstone Repeater");
        this.block = Block.get(BlockID.UNPOWERED_REPEATER);
    }
}
