package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockStickyPistonArmCollision extends Block {

    @Override
    public BlockID getId() {
        return BlockID.STICKY_PISTON_ARM_COLLISION;
    }

    @Override
    public String getName() {
        return "Sticky Piston Arm Collision";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STICKY_PISTON_ARM_COLLISION);
    }
}