package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLever extends Item {

    public ItemLever() {
        this(0, 1);
    }

    public ItemLever(Integer meta) {
        this(meta, 1);
    }

    public ItemLever(Integer meta, int count) {
        super(ItemID.LEVER, meta, count, "Lever");
        this.block = Block.get(BlockID.LEVER, meta);
    }
}