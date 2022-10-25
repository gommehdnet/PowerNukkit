package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNetherreactor extends Item {

    public ItemNetherreactor() {
        this(0, 1);
    }

    public ItemNetherreactor(Integer meta) {
        this(meta, 1);
    }

    public ItemNetherreactor(Integer meta, int count) {
        super(ItemID.NETHERREACTOR, meta, count, "Netherreactor");
        this.block = Block.get(BlockID.NETHERREACTOR, meta);
    }
}