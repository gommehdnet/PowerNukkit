package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrimsonPlanks extends Item {

    public ItemCrimsonPlanks() {
        this(0, 1);
    }

    public ItemCrimsonPlanks(Integer meta) {
        this(meta, 1);
    }

    public ItemCrimsonPlanks(Integer meta, int count) {
        super(ItemID.CRIMSON_PLANKS, meta, count, "Crimson Planks");
        this.block = Block.get(BlockID.CRIMSON_PLANKS, meta);
    }
}