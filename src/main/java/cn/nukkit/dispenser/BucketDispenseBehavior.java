package cn.nukkit.dispenser;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.*;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBucket;
import cn.nukkit.item.ItemID;
import cn.nukkit.math.BlockFace;

/**
 * @author CreeperFace
 */
public class BucketDispenseBehavior extends DefaultDispenseBehavior {

    @PowerNukkitOnly
    @Override
    public Item dispense(BlockDispenser block, BlockFace face, Item item) {
        if (!(item instanceof ItemBucket)) {
            return super.dispense(block, face, item);
        }

        ItemBucket bucket = (ItemBucket) item;
        Block target = block.getSide(face);

        if (!bucket.isEmpty()) {
            if (target.canBeFlowedInto() || target.getId() == BlockID.PORTAL) {
                Block replace = bucket.getTargetBlock();

                if (replace instanceof BlockLiquid) {
                    if (target.getId() == BlockID.PORTAL) {
                        target.onBreak(null);
                    }

                    block.level.setBlock(target, replace);
                    return Item.get(ItemID.BUCKET).setCompoundTag(bucket.getCompoundTag());
                }
            }
        } else if (target instanceof BlockFlowingWater && target.getDamage() == 0) {
            target.level.setBlock(target, Block.get(BlockID.AIR));
            return Item.get(ItemID.WATER_BUCKET).setCompoundTag(bucket.getCompoundTag());
        } else if (target instanceof BlockFlowingLava && target.getDamage() == 0) {
            target.level.setBlock(target, Block.get(BlockID.AIR));
            return Item.get(ItemID.LAVA_BUCKET).setCompoundTag(bucket.getCompoundTag());
        }

        return super.dispense(block, face, item);
    }
}
