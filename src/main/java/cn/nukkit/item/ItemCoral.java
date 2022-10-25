package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCoral extends Item {

    public ItemCoral() {
        this(0, 1);
    }

    public ItemCoral(Integer meta) {
        this(meta, 1);
    }

    public ItemCoral(Integer meta, int count) {
        super(ItemID.CORAL, meta, count, "Coral");
        this.block = Block.get(BlockID.CORAL, meta);
    }
}