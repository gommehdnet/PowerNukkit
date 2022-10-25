package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndPortal extends Item {

    public ItemEndPortal() {
        this(0, 1);
    }

    public ItemEndPortal(Integer meta) {
        this(meta, 1);
    }

    public ItemEndPortal(Integer meta, int count) {
        super(ItemID.END_PORTAL, meta, count, "End Portal");
        this.block = Block.get(BlockID.END_PORTAL, meta);
    }
}