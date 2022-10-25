package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCocoa extends Item {

    public ItemCocoa() {
        this(0, 1);
    }

    public ItemCocoa(Integer meta) {
        this(meta, 1);
    }

    public ItemCocoa(Integer meta, int count) {
        super(ItemID.COCOA, meta, count, "Cocoa");
        this.block = Block.get(BlockID.COCOA, meta);
    }
}