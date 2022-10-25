package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNetherWartBlock extends Item {

    public ItemNetherWartBlock() {
        this(0, 1);
    }

    public ItemNetherWartBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemNetherWartBlock(Integer meta, int count) {
        super(ItemID.NETHER_WART_BLOCK, meta, count, "Nether Wart Block");
        this.block = Block.get(BlockID.NETHER_WART_BLOCK, meta);
    }
}