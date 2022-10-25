package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSponge extends Item {

    public ItemSponge() {
        this(0, 1);
    }

    public ItemSponge(Integer meta) {
        this(meta, 1);
    }

    public ItemSponge(Integer meta, int count) {
        super(ItemID.SPONGE, meta, count, "Sponge");
        this.block = Block.get(BlockID.SPONGE, meta);
    }
}