package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemShroomlight extends Item {

    public ItemShroomlight() {
        this(0, 1);
    }

    public ItemShroomlight(Integer meta) {
        this(meta, 1);
    }

    public ItemShroomlight(Integer meta, int count) {
        super(ItemID.SHROOMLIGHT, meta, count, "Shroomlight");
        this.block = Block.get(BlockID.SHROOMLIGHT, meta);
    }
}