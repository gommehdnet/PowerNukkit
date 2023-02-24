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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockSmallDripleafBlock extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(CommonBlockProperties.DIRECTION, CommonBlockProperties.UPPER_BLOCK);

    @Override
    public BlockID getId() {
        return BlockID.SMALL_DRIPLEAF_BLOCK;
    }

    @Override
    public String getName() {
        return "Small Dripleaf Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SMALL_DRIPLEAF_BLOCK);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public int getBurnChance() {
        return 60;
    }

    @Override
    public int getBurnAbility() {
        return 100;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SHEARS;
    }

    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        if (face.equals(BlockFace.UP) && (target.getId().equals(BlockID.MOSS_BLOCK) || target.getId().equals(BlockID.CLAY))) {
            return super.place(item, block, target, face, fx, fy, fz, player);
        }

        return false;
    }
}