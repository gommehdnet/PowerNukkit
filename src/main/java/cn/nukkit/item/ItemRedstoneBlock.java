package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedstoneBlock extends Item {

    public ItemRedstoneBlock() {
        this(0, 1);
    }

    public ItemRedstoneBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemRedstoneBlock(Integer meta, int count) {
        super(ItemID.REDSTONE_BLOCK, meta, count, "Redstone Block");
        this.block = Block.get(BlockID.REDSTONE_BLOCK, meta);
    }
}