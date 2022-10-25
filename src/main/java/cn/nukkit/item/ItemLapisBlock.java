package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLapisBlock extends Item {

    public ItemLapisBlock() {
        this(0, 1);
    }

    public ItemLapisBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemLapisBlock(Integer meta, int count) {
        super(ItemID.LAPIS_BLOCK, meta, count, "Lapis Block");
        this.block = Block.get(BlockID.LAPIS_BLOCK, meta);
    }
}