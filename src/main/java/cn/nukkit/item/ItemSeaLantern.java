package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSeaLantern extends Item {

    public ItemSeaLantern() {
        this(0, 1);
    }

    public ItemSeaLantern(Integer meta) {
        this(meta, 1);
    }

    public ItemSeaLantern(Integer meta, int count) {
        super(ItemID.SEA_LANTERN, meta, count, "Sea Lantern");
        this.block = Block.get(BlockID.SEA_LANTERN, meta);
    }
}