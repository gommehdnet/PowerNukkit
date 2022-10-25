package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAmethystBlock extends Item {

    public ItemAmethystBlock() {
        this(0, 1);
    }

    public ItemAmethystBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemAmethystBlock(Integer meta, int count) {
        super(ItemID.AMETHYST_BLOCK, meta, count, "Amethyst Block");
        this.block = Block.get(BlockID.AMETHYST_BLOCK, meta);
    }
}