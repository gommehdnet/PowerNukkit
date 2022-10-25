package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSoulLantern extends Item {

    public ItemSoulLantern() {
        this(0, 1);
    }

    public ItemSoulLantern(Integer meta) {
        this(meta, 1);
    }

    public ItemSoulLantern(Integer meta, int count) {
        super(ItemID.SOUL_LANTERN, meta, count, "Soul Lantern");
        this.block = Block.get(BlockID.SOUL_LANTERN, meta);
    }
}