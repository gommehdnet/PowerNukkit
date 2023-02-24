package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.BooleanBlockProperty;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.math.BlockFace;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockBigDripleaf extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(new BooleanBlockProperty("big_dripleaf_head", false),
            new ArrayBlockProperty<>("big_dripleaf_tilt", false, BigDripleafTilt.values()), CommonBlockProperties.DIRECTION);

    private final List<BlockID> placementIds = Arrays.asList(BlockID.CLAY, BlockID.DIRT, BlockID.FARMLAND,
            BlockID.GRASS, BlockID.MOSS_BLOCK, BlockID.MYCELIUM, BlockID.PODZOL, BlockID.DIRT_WITH_ROOTS, BlockID.MUD);

    @Override
    public BlockID getId() {
        return BlockID.BIG_DRIPLEAF;
    }

    @Override
    public String getName() {
        return "Big Dripleaf";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BIG_DRIPLEAF);
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
        return 0.1;
    }

    @Override
    public double getResistance() {
        return 0.1;
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
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        if (face.equals(BlockFace.UP) && this.placementIds.contains(target.getId())) {
            return super.place(item, block, target, face, fx, fy, fz, player);
        }

        return false;
    }

    public enum BigDripleafTilt {
        NONE,
        UNSTABLE,
        PARTIAL_TILT,
        FULL_TILT
    }
}