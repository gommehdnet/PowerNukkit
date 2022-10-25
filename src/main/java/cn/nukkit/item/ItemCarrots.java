package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCarrots extends Item {

    public ItemCarrots() {
        this(0, 1);
    }

    public ItemCarrots(Integer meta) {
        this(meta, 1);
    }

    public ItemCarrots(Integer meta, int count) {
        super(ItemID.CARROTS, meta, count, "Carrots");
        this.block = Block.get(BlockID.CARROTS, meta);
    }
}