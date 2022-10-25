package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndGateway extends Item {

    public ItemEndGateway() {
        this(0, 1);
    }

    public ItemEndGateway(Integer meta) {
        this(meta, 1);
    }

    public ItemEndGateway(Integer meta, int count) {
        super(ItemID.END_GATEWAY, meta, count, "End Gateway");
        this.block = Block.get(BlockID.END_GATEWAY, meta);
    }
}