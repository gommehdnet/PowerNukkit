package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDripstoneBlock extends Item {

    public ItemDripstoneBlock() {
        this(0, 1);
    }

    public ItemDripstoneBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemDripstoneBlock(Integer meta, int count) {
        super(ItemID.DRIPSTONE_BLOCK, meta, count, "Dripstone Block");
        this.block = Block.get(BlockID.DRIPSTONE_BLOCK, meta);
    }
}