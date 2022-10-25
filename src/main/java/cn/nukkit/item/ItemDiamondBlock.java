package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDiamondBlock extends Item {

    public ItemDiamondBlock() {
        this(0, 1);
    }

    public ItemDiamondBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondBlock(Integer meta, int count) {
        super(ItemID.DIAMOND_BLOCK, meta, count, "Diamond Block");
        this.block = Block.get(BlockID.DIAMOND_BLOCK, meta);
    }
}