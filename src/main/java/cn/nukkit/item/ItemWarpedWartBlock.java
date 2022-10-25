package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWarpedWartBlock extends Item {

    public ItemWarpedWartBlock() {
        this(0, 1);
    }

    public ItemWarpedWartBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemWarpedWartBlock(Integer meta, int count) {
        super(ItemID.WARPED_WART_BLOCK, meta, count, "Warped Wart Block");
        this.block = Block.get(BlockID.WARPED_WART_BLOCK, meta);
    }
}