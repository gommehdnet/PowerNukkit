package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPlanks extends Item {

    public ItemPlanks() {
        this(0, 1);
    }

    public ItemPlanks(Integer meta) {
        this(meta, 1);
    }

    public ItemPlanks(Integer meta, int count) {
        super(ItemID.PLANKS, meta, count, "Planks");
        this.block = Block.get(BlockID.PLANKS, meta);
    }
}