package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMossBlock extends Item {

    public ItemMossBlock() {
        this(0, 1);
    }

    public ItemMossBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemMossBlock(Integer meta, int count) {
        super(ItemID.MOSS_BLOCK, meta, count, "Moss Block");
        this.block = Block.get(BlockID.MOSS_BLOCK, meta);
    }
}