package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLantern extends Item {

    public ItemLantern() {
        this(0, 1);
    }

    public ItemLantern(Integer meta) {
        this(meta, 1);
    }

    public ItemLantern(Integer meta, int count) {
        super(ItemID.LANTERN, meta, count, "Lantern");
        this.block = Block.get(BlockID.LANTERN, meta);
    }
}