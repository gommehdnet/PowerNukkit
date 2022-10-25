package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNetheriteBlock extends Item {

    public ItemNetheriteBlock() {
        this(0, 1);
    }

    public ItemNetheriteBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemNetheriteBlock(Integer meta, int count) {
        super(ItemID.NETHERITE_BLOCK, meta, count, "Netherite Block");
        this.block = Block.get(BlockID.NETHERITE_BLOCK, meta);
    }
}