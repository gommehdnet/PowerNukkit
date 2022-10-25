package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHayBlock extends Item {

    public ItemHayBlock() {
        this(0, 1);
    }

    public ItemHayBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemHayBlock(Integer meta, int count) {
        super(ItemID.HAY_BLOCK, meta, count, "Hay Block");
        this.block = Block.get(BlockID.HAY_BLOCK, meta);
    }
}