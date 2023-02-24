package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.IntBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCaveVinesHeadWithBerries extends BlockCaveVines {

    @Override
    public BlockID getId() {
        return BlockID.CAVE_VINES_HEAD_WITH_BERRIES;
    }

    @Override
    public String getName() {
        return "Cave Vines Head With Berries";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CAVE_VINES_HEAD_WITH_BERRIES);
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{Item.get(ItemID.GLOW_BERRIES)};
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        this.level.dropItem(this, Item.get(ItemID.GLOW_BERRIES));
        this.level.setBlock(this, Block.get(BlockID.CAVE_VINES));

        return false;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }
}