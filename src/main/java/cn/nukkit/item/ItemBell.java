package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBell extends Item {

    public ItemBell() {
        this(0, 1);
    }

    public ItemBell(Integer meta) {
        this(meta, 1);
    }

    public ItemBell(Integer meta, int count) {
        super(ItemID.BELL, meta, count, "Bell");
        this.block = Block.get(BlockID.BELL, meta);
    }
}