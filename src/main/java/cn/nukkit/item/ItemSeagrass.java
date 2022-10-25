package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSeagrass extends Item {

    public ItemSeagrass() {
        this(0, 1);
    }

    public ItemSeagrass(Integer meta) {
        this(meta, 1);
    }

    public ItemSeagrass(Integer meta, int count) {
        super(ItemID.SEAGRASS, meta, count, "Seagrass");
        this.block = Block.get(BlockID.SEAGRASS, meta);
    }
}