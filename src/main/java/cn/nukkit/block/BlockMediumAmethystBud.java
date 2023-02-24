package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.math.BlockFace;
import cn.nukkit.utils.Faceable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMediumAmethystBud extends BlockTransparentMeta implements Faceable {

    public static final BlockProperties PROPERTIES = new BlockProperties(CommonBlockProperties.FACING_DIRECTION);

    @Override
    public BlockID getId() {
        return BlockID.MEDIUM_AMETHYST_BUD;
    }

    @Override
    public String getName() {
        return "Medium Amethyst Bud";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MEDIUM_AMETHYST_BUD);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 1.5;
    }

    @Override
    public int getLightLevel() {
        return 2;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Since("1.3.0.0-PN")
    @PowerNukkitOnly
    @Override
    public void setBlockFace(BlockFace face) {
        this.setPropertyValue(CommonBlockProperties.FACING_DIRECTION, face);
    }

    @Override
    public BlockFace getBlockFace() {
        return this.getPropertyValue(CommonBlockProperties.FACING_DIRECTION);
    }

    @Override
    public Item[] getDrops(Item item) {
        return Item.EMPTY_ARRAY;
    }

    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        if (target.isFullBlock()) {
            this.setBlockFace(face);

            return super.place(item, block, target, face, fx, fy, fz, player);
        }

        return false;
    }

    @Override
    public boolean canSilkTouch() {
        return true;
    }
}