package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTallgrass extends Item {

    public ItemTallgrass() {
        this(0, 1);
    }

    public ItemTallgrass(Integer meta) {
        this(meta, 1);
    }

    public ItemTallgrass(Integer meta, int count) {
        super(ItemID.TALLGRASS, meta, count, "Tallgrass");
        this.block = Block.get(BlockID.TALLGRASS, meta);
    }
}