package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDirtWithRoots extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DIRT_WITH_ROOTS;
    }

    @Override
    public String getName() {
        return "Dirt With Roots";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DIRT_WITH_ROOTS);
    }

    @Override
    public double getHardness() {
        return 0.5;
    }

    @Override
    public double getResistance() {
        return 0.1;
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (item.isHoe()) {
            this.level.setBlock(this, Block.get(BlockID.DIRT));
            this.level.dropItem(this, Item.get(ItemID.HANGING_ROOTS));
        }

        return false;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }
}