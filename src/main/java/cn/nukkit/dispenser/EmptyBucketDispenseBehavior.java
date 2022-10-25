package cn.nukkit.dispenser;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.*;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.math.BlockFace;

/**
 * @author CreeperFace
 */
public class EmptyBucketDispenseBehavior extends DefaultDispenseBehavior {

    @PowerNukkitOnly
    @Override
    public Item dispense(BlockDispenser block, BlockFace face, Item item) {
        Block target = block.getSide(face);

        if (target instanceof BlockFlowingWater && target.getDamage() == 0) {
            target.level.setBlock(target, new BlockAir());
            return Item.get(ItemID.WATER_BUCKET).setCompoundTag(item.getCompoundTag());
        } else if (target instanceof BlockFlowingLava && target.getDamage() == 0) {
            target.level.setBlock(target, new BlockAir());
            return Item.get(ItemID.LAVA).setCompoundTag(item.getCompoundTag());
        }

        super.dispense(block, face, item);
        return null;
    }
}
