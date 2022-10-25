package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJukebox extends Item {

    public ItemJukebox() {
        this(0, 1);
    }

    public ItemJukebox(Integer meta) {
        this(meta, 1);
    }

    public ItemJukebox(Integer meta, int count) {
        super(ItemID.JUKEBOX, meta, count, "Jukebox");
        this.block = Block.get(BlockID.JUKEBOX, meta);
    }
}