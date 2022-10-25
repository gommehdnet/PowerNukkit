package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemUnpoweredRepeater extends Item {

    public ItemUnpoweredRepeater() {
        this(0, 1);
    }

    public ItemUnpoweredRepeater(Integer meta) {
        this(meta, 1);
    }

    public ItemUnpoweredRepeater(Integer meta, int count) {
        super(ItemID.UNPOWERED_REPEATER, meta, count, "Unpowered Repeater");
        this.block = Block.get(BlockID.UNPOWERED_REPEATER, meta);
    }
}