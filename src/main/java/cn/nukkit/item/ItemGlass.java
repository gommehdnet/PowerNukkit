package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlass extends Item {

    public ItemGlass() {
        this(0, 1);
    }

    public ItemGlass(Integer meta) {
        this(meta, 1);
    }

    public ItemGlass(Integer meta, int count) {
        super(ItemID.GLASS, meta, count, "Glass");
        this.block = Block.get(BlockID.GLASS, meta);
    }
}