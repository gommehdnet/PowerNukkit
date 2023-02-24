package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.math.BlockFace;
import cn.nukkit.utils.Faceable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockLightningRod extends Block implements Faceable {

    public static final BlockProperties PROPERTIES = new BlockProperties(CommonBlockProperties.FACING_DIRECTION);

    @Override
    public BlockID getId() {
        return BlockID.LIGHTNING_ROD;
    }

    @Override
    public String getName() {
        return "Lightning Rod";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIGHTNING_ROD);
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
        return 3;
    }

    @Override
    public double getResistance() {
        return 6;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getToolTier() {
        return ItemTool.TIER_STONE;
    }

    @Override
    public BlockFace getBlockFace() {
        return this.getPropertyValue(CommonBlockProperties.FACING_DIRECTION);
    }

    @Since("1.3.0.0-PN")
    @PowerNukkitOnly
    @Override
    public void setBlockFace(BlockFace face) {
        this.setPropertyValue(CommonBlockProperties.FACING_DIRECTION, face);
    }

    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        this.setBlockFace(face);

        return super.place(item, block, target, face, fx, fy, fz, player);
    }
}