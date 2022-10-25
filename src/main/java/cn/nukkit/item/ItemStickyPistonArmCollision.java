package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStickyPistonArmCollision extends Item {

    public ItemStickyPistonArmCollision() {
        this(0, 1);
    }

    public ItemStickyPistonArmCollision(Integer meta) {
        this(meta, 1);
    }

    public ItemStickyPistonArmCollision(Integer meta, int count) {
        super(ItemID.STICKY_PISTON_ARM_COLLISION, meta, count, "Sticky Piston Arm Collision");
        this.block = Block.get(BlockID.STICKY_PISTON_ARM_COLLISION, meta);
    }
}