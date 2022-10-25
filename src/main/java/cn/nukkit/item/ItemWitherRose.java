package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWitherRose extends Item {

    public ItemWitherRose() {
        this(0, 1);
    }

    public ItemWitherRose(Integer meta) {
        this(meta, 1);
    }

    public ItemWitherRose(Integer meta, int count) {
        super(ItemID.WITHER_ROSE, meta, count, "Wither Rose");
        this.block = Block.get(BlockID.WITHER_ROSE, meta);
    }
}