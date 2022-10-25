package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTurtleEgg extends Item {

    public ItemTurtleEgg() {
        this(0, 1);
    }

    public ItemTurtleEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTurtleEgg(Integer meta, int count) {
        super(ItemID.TURTLE_EGG, meta, count, "Turtle Egg");
        this.block = Block.get(BlockID.TURTLE_EGG, meta);
    }
}