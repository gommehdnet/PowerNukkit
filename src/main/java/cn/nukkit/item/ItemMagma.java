package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMagma extends Item {

    public ItemMagma() {
        this(0, 1);
    }

    public ItemMagma(Integer meta) {
        this(meta, 1);
    }

    public ItemMagma(Integer meta, int count) {
        super(ItemID.MAGMA, meta, count, "Magma");
        this.block = Block.get(BlockID.MAGMA, meta);
    }
}