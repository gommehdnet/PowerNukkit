package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockStickyPistonArmCollision extends Block {

    public static BlockProperties PROPERTIES = new BlockProperties(CommonBlockProperties.FACING_DIRECTION);

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

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}