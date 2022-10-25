package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPortal extends Item {

    public ItemPortal() {
        this(0, 1);
    }

    public ItemPortal(Integer meta) {
        this(meta, 1);
    }

    public ItemPortal(Integer meta, int count) {
        super(ItemID.PORTAL, meta, count, "Portal");
        this.block = Block.get(BlockID.PORTAL, meta);
    }
}