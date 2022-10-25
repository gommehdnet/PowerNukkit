package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPodzol extends Item {

    public ItemPodzol() {
        this(0, 1);
    }

    public ItemPodzol(Integer meta) {
        this(meta, 1);
    }

    public ItemPodzol(Integer meta, int count) {
        super(ItemID.PODZOL, meta, count, "Podzol");
        this.block = Block.get(BlockID.PODZOL, meta);
    }
}