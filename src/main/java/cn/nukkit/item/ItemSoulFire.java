package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSoulFire extends Item {

    public ItemSoulFire() {
        this(0, 1);
    }

    public ItemSoulFire(Integer meta) {
        this(meta, 1);
    }

    public ItemSoulFire(Integer meta, int count) {
        super(ItemID.SOUL_FIRE, meta, count, "Soul Fire");
        this.block = Block.get(BlockID.SOUL_FIRE, meta);
    }
}