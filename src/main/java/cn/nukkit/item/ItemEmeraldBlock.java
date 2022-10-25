package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEmeraldBlock extends Item {

    public ItemEmeraldBlock() {
        this(0, 1);
    }

    public ItemEmeraldBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemEmeraldBlock(Integer meta, int count) {
        super(ItemID.EMERALD_BLOCK, meta, count, "Emerald Block");
        this.block = Block.get(BlockID.EMERALD_BLOCK, meta);
    }
}