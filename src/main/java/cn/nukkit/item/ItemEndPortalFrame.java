package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndPortalFrame extends Item {

    public ItemEndPortalFrame() {
        this(0, 1);
    }

    public ItemEndPortalFrame(Integer meta) {
        this(meta, 1);
    }

    public ItemEndPortalFrame(Integer meta, int count) {
        super(ItemID.END_PORTAL_FRAME, meta, count, "End Portal Frame");
        this.block = Block.get(BlockID.END_PORTAL_FRAME, meta);
    }
}