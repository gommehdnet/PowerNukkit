package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPistonArmCollision extends Item {

    public ItemPistonArmCollision() {
        this(0, 1);
    }

    public ItemPistonArmCollision(Integer meta) {
        this(meta, 1);
    }

    public ItemPistonArmCollision(Integer meta, int count) {
        super(ItemID.PISTON_ARM_COLLISION, meta, count, "Piston Arm Collision");
        this.block = Block.get(BlockID.PISTON_ARM_COLLISION, meta);
    }
}