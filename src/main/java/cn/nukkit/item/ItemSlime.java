package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSlime extends Item {

    public ItemSlime() {
        this(0, 1);
    }

    public ItemSlime(Integer meta) {
        this(meta, 1);
    }

    public ItemSlime(Integer meta, int count) {
        super(ItemID.SLIME, meta, count, "Slime");
        this.block = Block.get(BlockID.SLIME, meta);
    }
}