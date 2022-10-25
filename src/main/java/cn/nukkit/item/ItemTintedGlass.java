package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTintedGlass extends Item {

    public ItemTintedGlass() {
        this(0, 1);
    }

    public ItemTintedGlass(Integer meta) {
        this(meta, 1);
    }

    public ItemTintedGlass(Integer meta, int count) {
        super(ItemID.TINTED_GLASS, meta, count, "Tinted Glass");
        this.block = Block.get(BlockID.TINTED_GLASS, meta);
    }
}