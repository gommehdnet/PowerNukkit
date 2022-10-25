package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSporeBlossom extends Item {

    public ItemSporeBlossom() {
        this(0, 1);
    }

    public ItemSporeBlossom(Integer meta) {
        this(meta, 1);
    }

    public ItemSporeBlossom(Integer meta, int count) {
        super(ItemID.SPORE_BLOSSOM, meta, count, "Spore Blossom");
        this.block = Block.get(BlockID.SPORE_BLOSSOM, meta);
    }
}