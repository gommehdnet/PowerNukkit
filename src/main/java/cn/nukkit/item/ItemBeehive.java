package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBeehive extends Item {

    public ItemBeehive() {
        this(0, 1);
    }

    public ItemBeehive(Integer meta) {
        this(meta, 1);
    }

    public ItemBeehive(Integer meta, int count) {
        super(ItemID.BEEHIVE, meta, count, "Beehive");
        this.block = Block.get(BlockID.BEEHIVE, meta);
    }
}