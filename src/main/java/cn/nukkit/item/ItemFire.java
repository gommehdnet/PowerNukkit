package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFire extends Item {

    public ItemFire() {
        this(0, 1);
    }

    public ItemFire(Integer meta) {
        this(meta, 1);
    }

    public ItemFire(Integer meta, int count) {
        super(ItemID.FIRE, meta, count, "Fire");
        this.block = Block.get(BlockID.FIRE, meta);
    }
}