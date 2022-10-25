package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveFence extends Item {

    public ItemMangroveFence() {
        this(0, 1);
    }

    public ItemMangroveFence(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveFence(Integer meta, int count) {
        super(ItemID.MANGROVE_FENCE, meta, count, "Mangrove Fence");
        this.block = Block.get(BlockID.MANGROVE_FENCE, meta);
    }
}